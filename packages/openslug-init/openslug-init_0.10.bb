DESCRIPTION = "Openslug initial network config via sysconf"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "base-files"
PR = "r9"

OPENSLUG_VERSION = "1.3-alpha"

SRC_URI = "file://sysconfsetup \
	   file://modutils.txt \
	   file://modprobe.conf \
	   file://kern_header.c"

inherit autotools update-rc.d

INITSCRIPT_NAME = "sysconfsetup"
INITSCRIPT_PARAMS = "defaults 39"

do_compile() {
	${CC} -o ${S}/../kern_header ${S}/../kern_header.c
}

do_install() {
	echo "OpenSlug-${OPENSLUG_VERSION}" > ${D}/.openslug

        install -d ${D}/${sysconfdir} \
                   ${D}/${sysconfdir}/init.d \
		   ${D}/${sysconfdir}/modutils \
                   ${D}/${sysconfdir}/rcS.d \
		   ${D}/${sbindir} 
		  
	install -d ${D}/initrd

	install -m 0755 ${D}/../kern_header ${D}${sbindir}/kern_header
	install -m 0755 ${D}/../sysconfsetup ${D}${sysconfdir}/init.d/
	install -m 0644 ${D}/../modutils.txt ${D}${sysconfdir}/modutils/
	install -m 0644 ${D}/../modprobe.conf ${D}${sysconfdir}/
	ln -s /etc/init.d/sysconfsetup ${D}${sysconfdir}/rcS.d/S39sysconfsetup
}

FILES_${PN} = "/"
