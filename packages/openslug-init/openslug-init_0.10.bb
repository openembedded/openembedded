DESCRIPTION = "Openslug initial network config via sysconf"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "base-files"
PR = "r24"

SRC_URI = "file://linuxrc \
	   file://boot/flash \
	   file://boot/disk \
	   file://boot/nfs \
	   file://boot/ram \
	   file://boot/network \
	   file://boot/udhcpc.script \
	   file://functions \
	   file://rmrecovery \
	   file://sysconfsetup \
	   file://turnup \
	   file://modutils.txt \
	   file://modprobe.conf \
	   file://leds_rs_green \
	   file://leds.h \
	   file://leds.c \
	   file://kern_header.c \
	   file://devio.c \
	   file://update-kernel"

SBINPROGS = "devio leds"
USRSBINPROGS = "kern_header"
CPROGS = "${USRSBINPROGS} ${SBINPROGS}"
SCRIPTS = "turnup update-kernel"
BOOTSCRIPTS = "flash disk nfs ram network udhcpc.script"

# This jsut makes things easier...
S="${WORKDIR}"

do_compile() {
	set -ex
	for p in ${CPROGS}
	do
		${CC} ${CFLAGS} -o $p $p.c
	done
	set +ex
}

do_install() {
	set -ex

	# Directories
        install -d ${D}${sysconfdir} \
                   ${D}${sysconfdir}/default \
                   ${D}${sysconfdir}/init.d \
		   ${D}${sysconfdir}/modutils \
		   ${D}${sbindir} \
		   ${D}${base_sbindir} \
		   ${D}/initrd \
		   ${D}/boot
		  
	# linuxrc
	rm -f ${D}/linuxrc
	ln -s boot/flash ${D}/linuxrc

	# C programs
	for p in ${USRSBINPROGS}
	do
		install -m 0755 $p ${D}${sbindir}/$p
	done
	for p in ${SBINPROGS}
	do
		install -m 0755 $p ${D}${base_sbindir}/$p
	done

	# Shell scripts
	for p in ${SCRIPTS}
	do
		install -m 0755 $p ${D}${sbindir}/$p
	done

	#
	# Init scripts
	install -m 0644 functions ${D}${sysconfdir}/default
	install -m 0755 rmrecovery ${D}${sysconfdir}/init.d/
	install -m 0755 sysconfsetup ${D}${sysconfdir}/init.d/
	install -m 0755 leds_rs_green ${D}${sysconfdir}/init.d/zleds_rs

	#
	# Boot scripts
	for p in ${BOOTSCRIPTS}
	do
		install -m 0755 boot/$p ${D}/boot
	done

	# Configuration files
	#XXinstall -m 0644 modutils.txt ${D}${sysconfdir}/modutils/
	install -m 0644 modprobe.conf ${D}${sysconfdir}/

	set +ex
}

# If the package is installed on an NSLU2 $D will be empty, in that
# case it is normal to run 'start' and 'stop', but because the conf
# files installed don't actually start or stop anything this is
# unnecessary, so the package postfoo handling is simplified here.
pkg_postinst_openslug-init() {
	opt=
	test -n "$D" && opt="-r $D"
	update-rc.d $opt sysconfsetup start 11 S .
	update-rc.d $opt zleds_rs start 99 S 1 2 3 4 5 . stop 05 0 1 2 3 4 5 6 .
}

pkg_postrm_openslug-init() {
	opt=
	test -n "$D" && opt="-r $D"
	update-rc.d $opt sysconfsetup remove
	update-rc.d $opt zleds_rs remove
}

PACKAGES = "${PN}"
FILES_${PN} = "/"

#CONFFILES_${PN} = "${sysconfdir}/modutils/modutils.txt ${sysconfdir}/modprobe.conf"
CONFFILES_${PN} = "${sysconfdir}/modprobe.conf"
