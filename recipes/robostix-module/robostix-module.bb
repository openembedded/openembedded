DESCRIPTION = "Linux Driver for Gumstix robostix daughtercards"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "kernel-${KERNEL_VERSION}"
DEPENDS = "virtual/kernel"

PR = "r2"

INITSCRIPT_NAME = "robostix"
INITSCRIPT_PARAMS = "defaults 10"

SRC_URI = "\
  file://Makefile \
  file://robostix.h \
  file://robostix.c \
  file://robostix.init \
 "

S = "${WORKDIR}"

inherit module update-rc.d

do_install() {	
	install         -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
  install -m 0644 ${WORKDIR}/robostix.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/

	install         -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/robostix.init ${D}${sysconfdir}/init.d/robostix
}

PACKAGES = "${PN}"

FILES_${PN} = "${base_libdir}/modules/"
FILES_${PN} += "${sysconfdir}/"

