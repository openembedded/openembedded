# SlugOS specific stuff for the init scripts.
#
# This is, in effect, an extended patch to fix various problems
# in the initscripts on SlugOS.  The problems mostly come down
# to the order in which the scripts are executed.

include initscripts_${PV}.bb

RCONFLICTS = "initscripts"

# SlugOS uses the busybox makedevs, so until that dependency gets virtualized
# the below lines serve to remove the dependency on the full makedevs package,
# as well as adding the dependency for the update-rc.d package.
DEPENDS = "update-rc.d-native"
RDEPENDS = "update-rc.d"

# All other standard definitions inherited from initscripts
# Except the PR which is hacked here.  The format used is
# a suffix
PR := "${PR}.22"

# We wish to search the same file paths as does the initscripts recipe.
FILESPATHPKG = "initscripts-${PV}:initscripts:files"

PACKAGES = "${PN}-dbg ${PN}"

SRC_URI += "file://alignment.sh"
SRC_URI += "file://domainname.sh"
SRC_URI += "file://bootclean.sh"

# Without this it is not possible to patch checkroot
S = "${WORKDIR}"

do_install_append() {
	# devfs is not used with SlugOS - remove all traces of it.
	rm	${D}${sysconfdir}/init.d/devices
	rm	${D}${sysconfdir}/rcS.d/S05devices

	# slugos specific scripts
	install -m 0755 ${WORKDIR}/alignment.sh ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/domainname.sh ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/bootclean.sh ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/checkroot ${D}${sysconfdir}/init.d

	# Remove the do install links (this detects a change to the
	# initscripts .bb file - it will cause a build failure here.)
	# This is a copy of the ln -sf lines from the initscripts
	# do_install.
	rm	${D}${sysconfdir}/rc2.d/S99rmnologin
	rm	${D}${sysconfdir}/rc3.d/S99rmnologin
	rm	${D}${sysconfdir}/rc4.d/S99rmnologin
	rm	${D}${sysconfdir}/rc5.d/S99rmnologin
	rm	${D}${sysconfdir}/rc6.d/S20sendsigs
#	rm	${D}${sysconfdir}/rc6.d/S30urandom
	rm	${D}${sysconfdir}/rc6.d/S31umountnfs.sh
	rm	${D}${sysconfdir}/rc6.d/S40umountfs
	rm      ${D}${sysconfdir}/rcS.d/S30ramdisk
	rm	${D}${sysconfdir}/rc6.d/S90reboot
	rm	${D}${sysconfdir}/rc0.d/S20sendsigs
#	rm	${D}${sysconfdir}/rc0.d/S30urandom
	rm	${D}${sysconfdir}/rc0.d/S31umountnfs.sh
	rm	${D}${sysconfdir}/rc0.d/S40umountfs
	rm	${D}${sysconfdir}/rc0.d/S90halt
	rm	${D}${sysconfdir}/rcS.d/S02banner
	rm	${D}${sysconfdir}/rcS.d/S10checkroot
#	rm	${D}${sysconfdir}/rcS.d/S30checkfs.sh
	rm	${D}${sysconfdir}/rcS.d/S35mountall.sh
	rm	${D}${sysconfdir}/rcS.d/S39hostname.sh
	rm	${D}${sysconfdir}/rcS.d/S45mountnfs.sh
	rm	${D}${sysconfdir}/rcS.d/S55bootmisc.sh
#	rm	${D}${sysconfdir}/rcS.d/S55urandom
	rm	${D}${sysconfdir}/rcS.d/S99finish.sh
	# udev will run at S04 if installed
	rm	${D}${sysconfdir}/rcS.d/S03sysfs
	rm	${D}${sysconfdir}/rcS.d/S38devpts.sh
	rm -f	${D}${sysconfdir}/rcS.d/S06alignment
	rm 	${D}${sysconfdir}/rcS.d/S37populate-volatile.sh
	rm 	${D}${sysconfdir}/rc0.d/S25save-rtc.sh
	rm      ${D}${sysconfdir}/rc6.d/S25save-rtc.sh



	# Check the result
	find ${D}${sysconfdir}/rc?.d ! -type d -print | {
		status=0
		while read d
		do
			oenote "initscripts-slugos: unexpected link $d"
			status=1
		done
		test $status -eq 0 ||
			oefatal "initscripts-slugos: new links break do_install"
	}

	# Set the run-level links
	#
	# Startup (S) links - UNCHANGED
	#
	# Keep these in order of startup - S, then 1, 2-5, 0,6
	# according to the level in which the script starts (or stops) first.
	update-rc.d -r ${D} banner		start  2 S .
	update-rc.d -r ${D} sysfs.sh		start  3 S .
	# udev runs at S 04 .
	update-rc.d -r ${D} alignment.sh	start  7 S .
	# busybox hwclock.sh (slugos-init) starts here (08)
	# slugos-init umountinitrd runs here (09)

	update-rc.d -r ${D} checkroot		start 10 S .
	# slugos buffer syslog starts here (11)
	# sysconfsetup runs at S 12
	# modutils.sh runs at S 20
	# checkfs.sh is currently disabled from S 30 (and won't work on SlugOS)
	# ramdisk is not used on SlugOS, would run at S 30
	update-rc.d -r ${D} mountall.sh		start 35 S .
	# bootclean must run after mountall but before populate-volatile
	update-rc.d -r ${D} bootclean.sh	start 36 S .
	# base-files populate-volatile.sh runs at S37
	update-rc.d -r ${D} devpts.sh		start 38 S .
	# slugos file syslog starts here (39)
	update-rc.d -r ${D} populate-volatile.sh	start 37 S .

	# set hostname and domainname before the network script works (by
	# entering them at level 40), networking may reset them.
	update-rc.d -r ${D} domainname.sh	start 40 S .
	update-rc.d -r ${D} hostname.sh		start 40 S .
	# network runs at S 40
	# slugos network syslog starts here (44)
	update-rc.d -r ${D} mountnfs.sh		start 45 S .

	update-rc.d -r ${D} bootmisc.sh		start 55 S .
	# urandom is currently disabled from S 55 (and won't work with tmpfs /var)

	# ipkg-cl configure runs at S 98
	update-rc.d -r ${D} finish.sh		start 99 S .

	#
	# User (2-5) links - UNCHANGED
	# rmnologin is the only thing added to user levels
	update-rc.d -r ${D} rmnologin		start 99 2 3 4 5 .

	#
	# Shutdown (0,6) links - !!!CHANGED!!!
	#
	# The problem here is that netbase installs K40networking but portmap
	# installs S32portmap.  One of these has to change!  The safe change
	# is to make the networking stop at S40, so all network related shutdown
	# must be in a K script or <S40.
	#
	# S20sendsigs is a disaster.  It needs to happen before the umounts
	# but after the portmapper (which it would otherwise kill).
	#
	# urandom would stop at (S)30

	# This is the special, correct, slugos umountnfs.sh (it looks in
	# the /proc/mounts information, not /etc/fstab)
	update-rc.d -r ${D} umountnfs.sh	start 31 0 6 .
	update-rc.d -r ${D} save-rtc.sh		start 25 0 6 .
	# portmap stops at 32
	# slugos network syslog stops here (39)
	# networking stops at 40 (nothing else does, believe me.)

	# busybox hwclock.sh (slugos-init) stops here (45)
	# slugos file syslog stops here (47)
	# slugos buffer syslog stops here (49)
	# udev stops here (55)
	# Remove any errant processes
	update-rc.d -r ${D} sendsigs		start 60 0 6 .

	# This is the special, correct, slugos umountfs, it will umount
	# any network file systems which failed to umount before.
	update-rc.d -r ${D} umountfs		start 70 0 6 .

	update-rc.d -r ${D} halt		start 90 0 .
	update-rc.d -r ${D} reboot		start 90 6 .
}
