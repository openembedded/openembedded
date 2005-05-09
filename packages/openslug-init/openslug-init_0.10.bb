DESCRIPTION = "Openslug initial network config via sysconf"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "base-files"
PR = "r22"

SRC_URI = "file://linuxrc \
	   file://sysconfsetup \
	   file://turnup \
	   file://modutils.txt \
	   file://modprobe.conf \
	   file://leds_rs_green \
	   file://leds.h \
	   file://leds.c \
	   file://kern_header.c \
	   file://update-kernel"

inherit autotools update-rc.d

INITSCRIPT_NAME = "sysconfsetup"
INITSCRIPT_PARAMS = "defaults 39"

do_compile() {
	${CC} -o ${S}/../kern_header ${S}/../kern_header.c
	${CC} -o ${S}/../leds ${S}/../leds.c
}

do_install() {
        install -d ${D}/${sysconfdir} \
                   ${D}/${sysconfdir}/init.d \
		   ${D}/${sysconfdir}/modutils \
                   ${D}/${sysconfdir}/rcS.d \
		   ${D}/${sbindir} 
		  
	install -m 0755 ${D}/../linuxrc ${D}/linuxrc

	install -d ${D}/initrd

	install -m 0755 ${D}/../kern_header ${D}${sbindir}/kern_header
	install -m 0755 ${D}/../update-kernel ${D}${sbindir}/update-kernel
	install -m 0755 ${D}/../turnup ${D}${sbindir}/turnup
	install -m 0755 ${D}/../leds ${D}${sbindir}/leds
	install -m 0755 ${D}/../sysconfsetup ${D}${sysconfdir}/init.d/
	install -m 0755 ${D}/../leds_rs_green ${D}${sysconfdir}/init.d/
	install -m 0644 ${D}/../modutils.txt ${D}${sysconfdir}/modutils/
	install -m 0644 ${D}/../modprobe.conf ${D}${sysconfdir}/
	rm -f ${D}${sysconfdir}/rcS.d/S39sysconfsetup
	ln -s ../init.d/sysconfsetup ${D}${sysconfdir}/rcS.d/S39sysconfsetup
	# Put this into the user run levels, after the rmnologin (which is
	# the thing that allows a user log in!)
	for l in 2 3 4 5
	do
		install -d ${D}/${sysconfdir}/rc$l.d
		rm -f ${D}${sysconfdir}/rc$l.d/S99zleds_rs_green
		ln -s ../init.d/leds_rs_green ${D}${sysconfdir}/rc$l.d/S99zleds_rs_green
	done
}

FILES_${PN} = "/"

CONFFILES_${PN} = "${sysconfdir}/modutils/modutils.txt ${sysconfdir}/modprobe.conf"
