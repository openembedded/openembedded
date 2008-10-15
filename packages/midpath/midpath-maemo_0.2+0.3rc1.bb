require midpath.inc

PR = "r0"

# The patch fixes the system_properties file only deployed in this recipe.
SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz \
  file://0.2+0.3rc1-fix-crlf.patch;patch=1;pnum=0 \
  "

S = "${WORKDIR}/midpath-0.3rc1"

PR = "r0"

SRC_URI += "file://configuration_maemo.cfg"

RDEPENDS += "java2-runtime libswt3.4-gtk-java midpath-core-bluetooth"

CONFIGURATION = "configuration_maemo.cfg"
