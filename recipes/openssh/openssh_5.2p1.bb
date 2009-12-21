require openssh.inc

PR = "${INC_PR}.1"

SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sshd_config \
           file://ssh_config \
           file://init \
           file://openssh-5.2-sftp-server-nolibcrypto.patch;patch=1 \
          "
