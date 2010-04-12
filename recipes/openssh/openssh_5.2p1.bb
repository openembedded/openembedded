require openssh.inc

PR = "${INC_PR}.1"

SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sshd_config \
           file://ssh_config \
           file://init \
           file://openssh-5.2-sftp-server-nolibcrypto.patch;patch=1 \
          "

SRC_URI[md5sum] = "ada79c7328a8551bdf55c95e631e7dad"
SRC_URI[sha256sum] = "4023710c37d0b3d79e6299cb79b6de2a31db7d581fe59e775a5351784034ecae"
