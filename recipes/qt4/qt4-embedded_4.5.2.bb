require qt4-embedded.inc

PR = "${INC_PR}.1"

LICENSE = "LGPLv2.1 GPLv3"
SRC_URI += "file://0010-no-simpledecoration-example.patch;patch=1 \
            file://hack-out-pg_config.patch;patch=1"

SRC_URI[md5sum] = "62186345c609a72b89f16d83bc7a130f"
SRC_URI[sha256sum] = "272301a27e2f7bcd44c8d09f496e1c749c80b86d9489ea9c30bb265bf2dd02fc"
