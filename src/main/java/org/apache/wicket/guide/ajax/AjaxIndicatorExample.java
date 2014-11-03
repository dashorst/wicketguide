package org.apache.wicket.guide.ajax;

import org.apache.wicket.ajax.IAjaxIndicatorAware;
import org.apache.wicket.extensions.ajax.markup.html.AjaxIndicatorAppender;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;

public class AjaxIndicatorExample {
  // tag::include[]
  public class MyComponent extends WebComponent implements IAjaxIndicatorAware { // <1>

    private AjaxIndicatorAppender indicatorAppender =
                new AjaxIndicatorAppender(); // <2>

    public MyComponent(String id, IModel<?> model) {
      super(id, model);
      add(indicatorAppender); // <3>
    }

    public String getAjaxIndicatorMarkupId() {
      return indicatorAppender.getMarkupId(); // <4>
    }

    // ...
  }
  // end::include[]
}
