# AES OE build file for the AMD Geode LX
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Linux AES Driver for the AMD Geode LX processor"
HOMEPAGE = "http://www.amd.com/embedded"

PR = "r0"
AMD_DRIVER_VERSION = "02.01.0100"
AMD_DRIVER_LABEL = "AES_Linux_LX_${AMD_DRIVER_VERSION}"

require geode-modules.inc

FILES_${PN} += " /etc"

do_install_append(){
        install -d ${D}/etc/modules.d
        echo options geodeaes rsvd_mem=0x200000 > ${D}/etc/modules.d/aes
}

SRC_URI[md5sum] = "12cb241a9037fffe31ba7c68a48ed614"
SRC_URI[sha256sum] = "a6068b4aa0e2330eed6e4741bad3191dc9ca7d7326f7bfab578ac55e2b8b91a2"
