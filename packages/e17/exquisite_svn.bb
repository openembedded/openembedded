DESCRIPTION = "A psplash replacement for display"
LICENSE = "MIT BSD"
DEPENDS = "eet evas ecore embryo edje"
PV = "0.0.1+svnr${SRCREV}"
PR = "r3"
RDEPENDS = "initscripts"
RRECOMMENDS_${PN} = "exquisite-themes"

SRCNAME = "exquisite"

inherit e

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

SRC_URI += "file://exquisite-init"

inherit update-rc.d

do_install_prepend() {
  install -d ${D}/mnt/.exquisite/
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/exquisite-init ${D}${sysconfdir}/init.d/exquisite
}


do_install_append() {
  rm -rf ${D}${datadir}/exquisite/data/fonts/*
}

INITSCRIPT_NAME = "exquisite"
INITSCRIPT_PARAMS = "start 01 S . stop 20 0 1 6 ."

FILES_${PN} += "/mnt/.exquisite/"
