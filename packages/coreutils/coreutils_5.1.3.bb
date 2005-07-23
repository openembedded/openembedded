LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "A collection of core GNU utilities."
RREPLACES = "textutils shellutils fileutils"
RPROVIDES = "textutils shellutils fileutils"
PR = "r2"

SRC_URI = "ftp://alpha.gnu.org/gnu/coreutils/coreutils-${PV}.tar.bz2 \
           file://install-cross.patch;patch=1;pnum=0 \
           file://man.patch;patch=1"

inherit autotools

bindir_progs = "basename cksum comm csplit cut dir dircolors dirname du \
		env expand expr factor fmt fold groups head hostid id install \
		join link logname md5sum mkfifo nice nl nohup od paste pathchk \
		pinky pr printenv printf ptx readlink seq sha1sum shred sort \
		split stat sum tac tail tee test tr tsort tty unexpand uniq \
		unlink uptime users vdir wc who whoami yes \
		"

base_bindir_progs = "cat chgrp chmod chown cp date dd echo false hostname kill \
		     ln ls mkdir mknod mv pwd rm rmdir sleep stty sync touch \
		     true uname \
		     "

sbindir_progs= "chroot"

do_install () {
	autotools_do_install
	
	# Renaming the utilities that should go in /usr/bin
	for i in ${bindir_progs}; do mv ${D}${bindir}/$i ${D}${bindir}/$i.${PN}; done
	mv ${D}${bindir}/[ ${D}${bindir}/[.${PN}
	
	# Renaming and moving the utilities that should go in /bin (FHS)
	install -d ${D}${base_bindir}
	for i in ${base_bindir_progs}; do mv ${D}${bindir}/$i ${D}${base_bindir}/$i.${PN}; done

	# Renaming and moving the utilities that should go in /usr/sbin (FHS)
	install -d ${D}${sbindir}
	for i in ${sbindir_progs}; do mv ${D}${bindir}/$i ${D}${sbindir}/$i.${PN}; done
}

pkg_postinst_${PN} () {
	# The utilities in /usr/bin
	for i in ${bindir_progs}; do update-alternatives --install ${bindir}/$i $i $i.${PN} 100; done
	update-alternatives --install "${bindir}/\[" "\[" "\[.${PN}" 100
	
	# The utilities in /bin
	for i in ${base_bindir_progs}; do update-alternatives --install ${base_bindir}/$i $i $i.${PN} 100; done
	
	# The utilities in /usr/sbin
	for i in ${sbindir_progs}; do update-alternatives --install ${sbindir}/$i $i $i.${PN} 100; done
}

pkg_prerm_${PN} () {
	# The utilities in /usr/bin
	for i in ${bindir_progs}; do update-alternatives --remove $i $i.${PN}; done
	update-alternatives --remove "\[" "\[.${PN}"

	# The utilities in /bin
	for i in ${base_bindir_progs}; do update-alternatives --remove $i $i.${PN}; done

	# The utilities in /usr/sbin
	for i in ${sbindir_progs}; do update-alternatives --remove $i $i.${PN}; done
}
