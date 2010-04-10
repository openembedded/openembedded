require openssh.inc
SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sftp-server-nolibcrypto.patch;patch=1 \
           file://sshd_config \
           file://ssh_config \
           file://init \
	   "
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "6a7fa99f44d9e1b5b04d15256e1405bb"
SRC_URI[sha256sum] = "7bbe277faa80c8d8d9cb96111db65fc0007d451784cc459207cd46b746a6f23a"
