require qt4-embedded.inc

PR = "${INC_PR}.1"

LICENSE = "LGPLv2.1 GPLv3"
SRC_URI += "file://0010-no-simpledecoration-example.patch;patch=1 \
            file://hack-out-pg_config.patch;patch=1"
