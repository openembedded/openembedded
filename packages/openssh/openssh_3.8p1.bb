DEPENDS = "zlib openssl"
SECTION = "console/network"
DESCRIPTION = "Secure rlogin/rsh/rcp/telnet replacement (OpenSSH) \
Ssh (Secure Shell) is a program for logging into a remote machine \
and for executing commands on a remote machine. \
It provides secure encrypted communications between two untrusted \
hosts over an insecure network.  X11 connections and arbitrary TCP/IP \
ports can also be forwarded over the secure channel. \
It is intended as a replacement for rlogin, rsh and rcp, and can be \
used to provide applications with a secure communication channel."
HOMEPAGE = "http://www.openssh.org/"
LICENSE = "BSD"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
PR = "r2"

SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://scp-nossl.patch;patch=1 \
           file://sshd_config \
           file://init"

inherit autotools

export ASKPASS_PROGRAM = "${bindir}/ssh-askpass"
export LD = "${CC}"
CFLAGS_prepend = "-I${S} "
CFLAGS_append = " -D__FILE_OFFSET_BITS=64"
LDFLAGS_prepend = "-L${S} -L${S}/openbsd-compat "
EXTRA_OECONF = "--disable-suid-ssh --with-ssl=${STAGING_LIBDIR}/ssl \
	        --with-rand-helper=no --without-pam \
	        --without-zlib-version-check \
		--with-privsep-path=/var/run/sshd \
		--sysconfdir=${sysconfdir}/ssh"
		
EXTRA_OEMAKE = "'STRIP_OPT='"

do_configure_prepend () {
	if [ ! -e acinclude.m4 -a -e aclocal.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_compile_append () {
	install -m 0644 ${WORKDIR}/sshd_config ${S}/
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/sshd
}

PACKAGES =+ " openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc"
FILES_openssh-scp = "${bindir}/scp"
FILES_openssh-ssh = "${bindir}/ssh ${bindir}/slogin /${sysconfdir}/ssh/ssh_config"
FILES_openssh-sshd = "${sbindir}/sshd /${sysconfdir}/init.d/sshd ${bindir}/ssh-keygen"
FILES_openssh-sshd += " /${sysconfdir}/ssh/moduli /${sysconfdir}/ssh/sshd_config /var/run/sshd"
FILES_openssh-sftp = "${bindir}/sftp ${libdir}exec/sftp-server"
FILES_openssh-misc = "${bindir} ${libdir}exec/"
RDEPENDS_openssh += " openssh-scp openssh-ssh openssh-sshd"
DEPENDS_openssh-sshd += " update-rc.d"
RDEPENDS_openssh-sshd += " update-rc.d"

pkg_postinst_openssh-sshd() {
if test "x$D" != "x"; then
	exit 1
else
	addgroup sshd
	adduser --system --home /var/run/sshd --no-create-home --disabled-password --ingroup sshd -s /bin/false sshd
	update-rc.d sshd defaults
fi
}

pkg_postrm_openssh-sshd() {
if test "x$D" != "x"; then
	exit 1
else
	${sysconfdir}/init.d/sshd stop
	deluser sshd
	delgroup sshd
	update-rc.d -f sshd remove
fi
}

CONFFILES_openssh-sshd = "${sysconfdir}/ssh/sshd_config"
CONFFILES_openssh-ssh = "${sysconfdir}/ssh/ssh_config"
