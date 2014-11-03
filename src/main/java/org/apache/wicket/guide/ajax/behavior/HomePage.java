package org.apache.wicket.guide.ajax.behavior;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

// tag::include[]
public class HomePage extends WebPage {
    public HomePage(final PageParameters parameters) {
        super(parameters);

        final ClickCounterLabel clickCounterLabel =
            new ClickCounterLabel("clickCounterLabel", "Click on me!");
        final Label clickCounter =
            new Label("clickCounter", new PropertyModel(clickCounterLabel, "clickCounter"));


        clickCounterLabel.setOutputMarkupId(true);
        clickCounterLabel.add(new AjaxEventBehavior("click") {
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                clickCounterLabel.clickCounter++;
                target.add(clickCounter);
            }
        });

        add(clickCounterLabel);
        add(clickCounter.setOutputMarkupId(true));
    }
}

class ClickCounterLabel extends Label {
    public int clickCounter;

    public ClickCounterLabel(String id) {
        super(id);
    }

    public ClickCounterLabel(String id, IModel<?> model) {
        super(id, model);
    }

    public ClickCounterLabel(String id, String label) {
        super(id, label);
    }
}
// tag::include[]
