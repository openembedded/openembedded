require xorg-doc-common.inc

DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."

DEPENDS += " intltool"

PE = "1"

FILES_${PN} += " /usr/share/X11/doc"

EXTRA_OECONF += " ac_cv_file__usr_share_sgml_X11_defs_ent=no "

SRC_URI[archive.md5sum] = "359ac83ad27eecd5588914ba8715301d"
SRC_URI[archive.sha256sum] = "62cc63582e97ad76a02acdb409123ff0e2cf33df25c9977e3b8a7606be75eafc"
