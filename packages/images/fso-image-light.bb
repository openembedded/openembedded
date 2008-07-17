#------------------------------------------------------
# freesmartphone.org Image Recipe, Light Edition
#------------------------------------------------------

require fso-image.bb

IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${PYTHON_INSTALL} \
  ${ZHONE_INSTALL} \
"
