package cn.lut.curiezhang.action;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lut.curiezhang.model.Examinee;
import cn.lut.curiezhang.service.ExamineeService;

/**
 * SSH��ܽ��п����������ͼ���Action��
 * @author curiezhang
 *
 */
public class ExamineeAction extends ActionSupport implements ModelDriven<Object> {
	/**
	 * ExamineeAction��ID
	 */
	private static final long serialVersionUID = -2978659526717330712L;
	private static final Logger log = LogManager.getLogger(ExamineeAction.class);
	/**
	 * Struts��Spring���Ϲ����а������Զ�ע���ҵ������
	 */
	private ExamineeService examineeService;
	public void setExamineeService(ExamineeService examineeService) {
		log.debug("Action > ע���Service��");
		this.examineeService = examineeService;
	}
	
	/**
	 * Action��ģ������ʹ�õ���
	 */
	private Examinee model = new Examinee();
	public void setModel(Examinee model) {
		log.debug("Action > ����ģ��ֵ��idΪ{}", examineeId);
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (list != null) {
			if(list.size() != 0)
				log.debug("Action > �õ��б��һ��Ԫ��idֵ��idΪ{}", ((Examinee) list.iterator().next()).getExamineeId());
			return list;
		} else {
			log.debug("Action > �õ�ģ��ֵ��idΪ{}", examineeId);
			return model;
		}
	}

	/**
	 * Action������Ψһidʹ�õĲ���
	 */
	private String examineeId;
	public String getExamineeId() {
		log.debug("Action > �õ�����id��idΪ{}", examineeId);
		return examineeId;
	}
	public void setExamineeId(String examineeId) {
		log.debug("Action > ���ÿ���id��idΪ{}", examineeId);
		if(examineeId != null) {
			this.model = examineeService.getExamineeId(examineeId);
		}
		this.examineeId = examineeId;
	}
	
	/**
	 * Action��������������ʱ�ķ��ؽ��
	 * @return list
	 */
	private Collection<Examinee> list;
	public Collection<Examinee> getList() {
		log.debug("Action > ��ѯ���п���");
		return list;
	}
	
	/**
	 * Action����д��ʱִ�и÷������ɽ�����Ч����֤
	 * @return true ����ͨ����Ч����֤
	 */
	public void validate() {
		log.debug("Action > ��Ч����֤��idΪ{}", examineeId);
    }

	/**
	 * Action����ҳ
	 */
    public String index() {
    	log.debug("Action > ����indexҳ��");
    	list = examineeService.getAll();
		return SUCCESS;
    }
	/**
	 * Action�����
	 */
    public String add() {
    	log.debug("Action > ����addҳ��");
    	model = new Examinee();
    	return "success";
    }
	/**
	 * Action��ȷ��ɾ��
	 */
    public String deleteConfirm() {
    	log.debug("Action > ����deleteConfirmҳ��");
    	return "success";
    }
	/**
	 * Action���޸�
	 */
    public String modify() {
    	log.debug("Action > ����modifyҳ��");
    	return "success";
    }
	/**
	 * Action�в�ѯ
	 */
    public String browse() {
    	log.debug("Action > ����browseҳ��");
    	return "success";
    }
	/**
	 * Action�е�¼
	 */
    public String loginAdmin() {
    	log.debug("Action > ���ʹ���Ա��¼ҳ��");
    	return "loginAdmin";
    }
    
    /**
     * Action�д����µĿ���
     * @return
     */
    public String create() {
    	log.debug("Action > ����¿�����idΪ {}", examineeId);
        String info = examineeService.save(model);
        addActionMessage(info);
        return "success";
    }

    /**
     * Action��ɾ��ָ��id�Ŀ���
     * @return
     */
    public String delete() {
        log.debug("Action > ɾ��ָ��id�Ŀ�����idΪ {}", examineeId);
    	String info = examineeService.delete(examineeId);
        addActionMessage(info);
        return "success";
    }

    /**
     * Action���޸Ŀ�����Ϣ
     * @return
     */
    public String update() {
    	log.debug("Action > �޸Ŀ�����Ϣ��idΪ {}", examineeId);
    	String info = examineeService.update(model);
        addActionMessage(info);
        return "success";
    }
}
