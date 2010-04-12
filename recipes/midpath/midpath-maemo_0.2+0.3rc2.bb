require midpath.inc

PR = "r0"

# The patch fixes the system_properties file only deployed in this recipe.
SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz \
  "

S = "${WORKDIR}/midpath-0.3rc2"

PR = "r0"

SRC_URI += "file://configuration_maemo.cfg"

RDEPENDS += "java2-runtime libswt3.4-gtk-java midpath-core-bluetooth"

CONFIGURATION = "configuration_maemo.cfg"

SRC_URI[md5sum] = "d03cd88f51f82bbcfcfa5b65df0da5b0"
SRC_URI[sha256sum] = "e235ca7470e7cdfb90e3806fbcc1b2c450db286276136a2523c7ae26a804a100"
