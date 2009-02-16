#------------------------------------------------------
# freesmartphone.org Image Recipe, Light Edition
#------------------------------------------------------

require fso-image.inc

IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${PYTHON_INSTALL} \
  ${ZHONE_INSTALL} \
"
