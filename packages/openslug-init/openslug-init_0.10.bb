DESCRIPTION = "Openslug initial network config via sysconf"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "base-files"
PR = "r10"

OPENSLUG_VERSION = "1.3-alpha"

SRC_URI = "file://sysconfsetup \
	   file://modutils.txt \
	   file://modprobe.conf \
	   file://leds_rs_green \
	   file://leds.h \
	   file://leds.c \
	   file://kern_header.c"

inherit autotools update-rc.d

INITSCRIPT_NAME = "sysconfsetup"
INITSCRIPT_PARAMS = "defaults 39"

do_compile() {
	${CC} -o ${S}/../kern_header ${S}/../kern_header.c
	${CC} -o ${S}/../leds ${S}/../leds.c
}

do_install() {
	echo "OpenSlug-${OPENSLUG_VERSION}" > ${D}/.openslug

        install -d ${D}/${sysconfdir} \
                   ${D}/${sysconfdir}/init.d \
		   ${D}/${sysconfdir}/modutils \
                   ${D}/${sysconfdir}/rcS.d \
                   ${D}/${sysconfdir}/rc2.d \
		   ${D}/${sbindir} 
		  
	install -d ${D}/initrd

	install -m 0755 ${D}/../kern_header ${D}${sbindir}/kern_header
	install -m 0755 ${D}/../leds ${D}${sbindir}/leds
	install -m 0755 ${D}/../sysconfsetup ${D}${sysconfdir}/init.d/
	install -m 0755 ${D}/../leds_rs_green ${D}${sysconfdir}/init.d/
	install -m 0644 ${D}/../modutils.txt ${D}${sysconfdir}/modutils/
	install -m 0644 ${D}/../modprobe.conf ${D}${sysconfdir}/
	ln -s /etc/init.d/sysconfsetup ${D}${sysconfdir}/rcS.d/S39sysconfsetup
	ln -s /etc/init.d/leds_rs_green ${D}${sysconfdir}/rc2.d/S98leds_rs_green
}

FILES_${PN} = "/"
