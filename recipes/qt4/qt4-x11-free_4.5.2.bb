require qt4-x11-free.inc
LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.4"

SRC_URI += "file://hack-out-pg_config.patch \
            file://openssl-1.0.patch \
           "

SRC_URI[md5sum] = "d8bcc070a58db25c228b7729ffad4550"
SRC_URI[sha256sum] = "4e4c8619335cac14ba0c52d1555fab549a562fb774c1c08dcbd2be9de38120a2"
