package seo.dale.commerce.core;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

//@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "user";
    }

}
