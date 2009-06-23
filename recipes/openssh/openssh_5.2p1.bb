require openssh.inc
DEFAULT_PREFERENCE = "-1" 
#not tested extensively(I tested only ssh) and it's an important recipe I'm afraid to broke
SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sshd_config \
           file://ssh_config \
           file://init \
           file://openssh-5.2-sftp-server-nolibcrypto.patch;patch=1 \
          "
