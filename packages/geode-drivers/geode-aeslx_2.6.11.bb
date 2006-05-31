# AES OE build file for the AMD Geode LX
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Linux AES Driver for the AMD Geode LX processor"
HOMEPAGE = "http://www.amd.com/embedded"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"

PR = "r0"
AMD_DRIVER_VERSION = "02.01.0100"
AMD_DRIVER_LABEL = "AES_Linux_LX_${AMD_DRIVER_VERSION}"

include geode-modules.inc

FILES_${PN} += " /etc"

do_install_append(){ 
        install -d ${D}/etc/modules.d
        echo options geodeaes rsvd_mem=0x200000 > ${D}/etc/modules.d/aes
}
