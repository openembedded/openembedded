SECTION = "base"
DESCRIPTION = "System-V like init.\
 Init is the first program to run after your system is booted, and\
 continues to run as process number 1 until your system halts. Inits\
 job is to start other programs that are essential to the operation of\
 your system. All processes are descended from init. For more information,\
 see the manual page init(8)."
PACKAGES = "sysvinit"
FILES_${PN} = "${base_sbindir} ${bindir} ${sysconfdir}"
FILES_sysv-rc = "${sbindir}"
PR = "r1"
LICENSE = "GPL"
# USE_VT and SERIAL_CONSLE are generally defined by the MACHINE .conf.
# Set PACKAGE_ARCH appropriately.
PACKAGE_ARCH = "${MACHINE_ARCH}"

USE_VT ?= "1"

SRC_URI = "ftp://ftp.cistron.nl/pub/people/miquels/sysvinit/sysvinit-${PV}.tar.gz \
           file://need \
           file://provide \
           file://inittab \
           file://rcS-default \
           file://rc \
           file://rcS"
S = "${WORKDIR}/sysvinit-${PV}/src"

CFLAGS_prepend = "-D_GNU_SOURCE "
export LCRYPT = "-lcrypt"


do_install () {
	install -d ${D}${bindir} ${D}${sbindir} \
		   ${D}${base_sbindir} ${D}${sysconfdir}/default \
		   ${D}${sysconfdir}/init.d
	install -m 755 halt killall5 \
		runlevel shutdown ${D}${base_sbindir}/
	install -m 755 init ${D}${base_sbindir}/sysvinit
	install -m 755 mesg last ${D}${bindir}
	install -m 0755 ${WORKDIR}/need		${D}${base_sbindir}/need.sysvinit
	install -m 0755 ${WORKDIR}/provide		${D}${base_sbindir}/provide.sysvinit
	ln -sf halt ${D}${base_sbindir}/reboot
	ln -sf halt ${D}${base_sbindir}/poweroff
	ln -sf init ${D}${base_sbindir}/telinit
	ln -sf killall5 ${D}${base_sbindir}/pidof
	ln -sf last ${D}${bindir}/lastb
	install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
	if [ ! -z "${SERIAL_CONSOLE}" ]; then
		echo "S:2345:respawn:${base_sbindir}/getty ${SERIAL_CONSOLE}" >> ${D}${sysconfdir}/inittab
	fi
	if [ "${USE_VT}" == "1" ]; then
		cat <<EOF >>${D}${sysconfdir}/inittab
# ${base_sbindir}/getty invocations for the runlevels.
#
# The "id" field MUST be the same as the last
# characters of the device (after "tty").
#
# Format:
#  <id>:<runlevels>:<action>:<process>
#
1:2345:respawn:${base_sbindir}/getty 38400 tty1
# 2:23:respawn:${base_sbindir}/getty 38400 tty2
# 3:23:respawn:${base_sbindir}/getty 38400 tty3
# 4:23:respawn:${base_sbindir}/getty 38400 tty4
EOF
	fi
	install -m 0644    ${WORKDIR}/rcS-default	${D}${sysconfdir}/default/rcS
	install -m 0755    ${WORKDIR}/rc		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rcS		${D}${sysconfdir}/init.d
}


do_install_append_ramses () {
	cat <<EOF >>${D}${sysconfdir}/inittab
# Bluetooth
#1:2345:respawn:${base_sbindir}/getty -L 115200 tts/1
# External serial port
4:2345:respawn:${base_sbindir}/getty -L 115200 tts/4
# Framebuffer
v1:2345:respawn:${base_sbindir}/getty -L 115200 vc/1
EOF
}


pkg_postinst () {
set -e
# FIXME: use update-alternatives.. but what if the user doesnt have it?
#if [ -n "`which update-alternatives 2>/dev/null`" ]; then
#	update-alternatives blah
#else
	ln -sf sysvinit $D/sbin/init
#fi
exit 0
}
