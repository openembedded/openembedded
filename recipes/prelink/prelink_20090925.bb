SECTION = "devel"
DEPENDS = "elfutils"
DESCRIPTION = " The prelink package contains a utility which modifies ELF shared libraries \
and executables, so that far fewer relocations need to be resolved at \
runtime and thus programs come up faster."
LICENSE = "GPL"

SRC_URI = "${DEBIAN_MIRROR}/main/p/prelink/prelink_0.0.${PV}.orig.tar.gz \
           file://prelink.conf \
           file://prelink.cron.daily \
           file://prelink.default"

#TARGET_OS_ORIG := "${TARGET_OS}"
#OVERRIDES_append = ":${TARGET_OS_ORIG}"
#SRC_URI_append_linux-gnueabi = " file://arm_eabi.patch;patch=1"

S = "${WORKDIR}/prelink-0.0.${PV}"

EXTRA_OECONF = "--disable-64bit"

inherit autotools 

do_install_append () {
	install -d ${D}${sysconfdir}/cron.daily ${D}${sysconfdir}/default
	install -m 0644 ${WORKDIR}/prelink.conf ${D}${sysconfdir}/prelink.conf
	install -m 0644 ${WORKDIR}/prelink.cron.daily ${D}${sysconfdir}/cron.daily/prelink
	install -m 0644 ${WORKDIR}/prelink.default ${D}${sysconfdir}/default/prelink
}

pkg_postinst_prelink() {
#!/bin/sh

if [ "x$D" != "x" ]; then
  exit 1
fi

. ${sysconfdir}/cron.daily/prelink
}

pkg_prerm_prelink() {
#!/bin/sh

if [ -f ${sysconfdir}/prelink.cache ]; then
    prelink -au
    rm -f ${sysconfdir}/prelink.cache
fi
}


SRC_URI[md5sum] = "ed90412ad4ee7f5b5e8fff3d6649e49b"
SRC_URI[sha256sum] = "2110261aedd8423fa3f1dba5ecb08bd61beb708883f82753b09835076cba2e36"
