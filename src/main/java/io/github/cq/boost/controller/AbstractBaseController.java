package io.github.cq.boost.controller;

abstract class AbstractBaseController {

  /**
   * The default template name, this shouldn't change under normal circumstances.
   */
  final String TEMPLATE_DEFAULT = "default";

  final String currentTemplateName() {
    // returning default from now
    return TEMPLATE_DEFAULT;
  }
  
  final String computeTemplate(final String viewName) {
    return TEMPLATE_DEFAULT + "/" + viewName;
  }

}
