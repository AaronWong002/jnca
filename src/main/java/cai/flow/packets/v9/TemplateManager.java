package cai.flow.packets.v9;

import java.io.File;
import java.util.Hashtable;
import cai.utils.Resources;
import cai.utils.Params;
import cai.utils.DoneException;

public class TemplateManager {
    private Template v5Template = null;

    private Resources resources = new Resources("serverSampling");

    private static String v5FileName = "127.0.0.0_32.properties";
    static {
        System.out.println("TemplateManager-static:1");
        try {
            Class.forName("cai.flow.collector.Collector");
            System.out.println("TemplateManager-static:2");
        } catch (Exception ex) {
            System.out.println("TemplateManager-static:3");
            ex.printStackTrace();
        }
    }

    private TemplateManager() {
        System.out.println("TemplateManager-TemplateManager():1");
        try {
            System.out.println("TemplateManager-TemplateManager():v5FileName="+v5FileName);
            v5Template = new Template(v5FileName);
            System.out.println("TemplateManager-TemplateManager():v5Template="+v5Template.getRouterIp());
            int samRate = resources.integer(v5Template.getRouterIp());
            System.out.println("TemplateManager-TemplateManager():samRate="+samRate);
            if (samRate != 0) {
                v5Template.setSamplingRate(samRate);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // ��������ֱ�ӵõ�template���������ȡ
        System.out.println("TemplateManager-TemplateManager():cai.utils.Params.template_refreshFromHD="+cai.utils.Params.template_refreshFromHD);
        if (cai.utils.Params.template_refreshFromHD) {
            File tpPath = new File(Template.templatePath);
            if (tpPath.exists() && tpPath.isDirectory()) {
                String[] fileNames = tpPath.list();
                for (int idx = 0; idx < fileNames.length; idx++) {
                    Template t;
                    try {
                        if (fileNames[idx].indexOf(v5FileName) == -1) {
                            t = new Template(fileNames[idx]);
                            int samRate = resources.integer(t.getRouterIp());
                            if (samRate != 0) {
                                t.setSamplingRate(samRate);
                            }
                            templates.put(t.getRouterIp() + t.getTemplateId(),
                                          t);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        // ��Ӱ����һ��template
                    }
                }
            } else {
                System.err.println("ϵͳ�⵽�ƻ�");
            }
        }
    }

    private static TemplateManager mgr = new TemplateManager();

    Hashtable templates = new Hashtable();

    public static synchronized TemplateManager getTemplateManager() {
        return mgr;
    }

    public synchronized boolean acceptTemplate(String routerIp, byte[] content,
                                               int offset) throws Exception {
        Exception ex = null;
        if (offset > 3) {
            Template t = null;
            try{
                t = new Template(routerIp, content, offset);
            }catch(Exception ex2){
                ex=ex2;
            }
            int samRate = resources.integer(t.getRouterIp());
            if (samRate != 0) {
                t.setSamplingRate(samRate);
            }
            templates.put(t.getRouterIp() + t.getTemplateId(), t);
            if (ex!=null){
                throw ex;
            }
            return true;
        }
        return false;
    }

    public synchronized Template getTemplate(String routerIp, int templateId) {
        return (Template) templates.get(routerIp + templateId);
    }

    /**
     * @return Returns the v5Template.
     */
    public Template getV5Template() {
        return v5Template;
    }

    /**
     * @param template
     *            The v5Template to set.
     */
    public void setV5Template(Template template) {
        v5Template = template;
    }
}
