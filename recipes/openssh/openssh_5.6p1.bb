require openssh.inc

PR = "${INC_PR}.0"

SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sshd_config \
           file://ssh_config \
           file://init \
           file://openssh-5.2-sftp-server-nolibcrypto.patch \
          "
SRC_URI[md5sum] = "e6ee52e47c768bf0ec42a232b5d18fb0"
SRC_URI[sha256sum] = "538af53b2b8162c21a293bb004ae2bdb141abd250f61b4cea55244749f3c6c2b"

