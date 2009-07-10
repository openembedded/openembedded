#------------------------------------------------------
# freesmartphone.org Image Recipe
#------------------------------------------------------

require fso-image.inc

PV = "1.1"
PR = "r5"

ZHONE_INSTALL = "\
  task-fso-compliance \
  zhone \
"

ZHONE_INSTALL_append_om-gta02 = "\
  midori \
"
