require openssh.inc
SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sftp-server-nolibcrypto.patch;patch=1 \
           file://sshd_config \
           file://ssh_config \
           file://init \
	   "
PR = "${INC_PR}.0"
