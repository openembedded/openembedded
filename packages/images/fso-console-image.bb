#------------------------------------------------------
# freesmartphone.org Console Image Recipe
#------------------------------------------------------

require fso-image.bb

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  frameworkd \
"
