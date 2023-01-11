package util;

import dto.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * My own tag for role validation
 */
public class UserRoleTag extends TagSupport {
    private String role;

    @Override
    public int doStartTag() throws JspException {
        if (getRequest().getSession().getAttribute("currentUser") == null) {
            if (role.equals("none")) {
                    return EVAL_BODY_INCLUDE;
            }
        }else{
            if (((User) getRequest().getSession().getAttribute("currentUser")).getRole().toString().equals(role)) {
                return EVAL_BODY_INCLUDE;
            }
        }
        return SKIP_BODY;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) pageContext.getRequest();
    }
}
