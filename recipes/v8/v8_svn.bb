# v8 OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "V8 is Google's open source JavaScript engine."
HOMEPAGE = "http://code.google.com/p/v8/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

PV = "0.0+svnr${SRCPV}"
SRCREV = "3431"

SRC_URI = "svn://v8.googlecode.com/svn/;module=trunk;proto=http;rev=${SRCREV} \
        file://SConstruct.patch \
        file://0004-add-the-install-target.patch \
	 "

S = "${WORKDIR}/trunk"

export V8_TARGET_ARCH_ARM = "\
                 -msoft-float \
                 -fpic \
                 -funwind-tables \
                 -fstack-protector \
                 -fno-short-enums \
                 -fmessage-length=0 \
                 -finline-functions \
                 -fno-inline-functions-called-once \
                 -fgcse-after-reload \
                 -frerun-cse-after-loop \
                 -frename-registers \
                 -fomit-frame-pointer \
                 -fno-strict-aliasing \
                 -finline-limit=64 \
                 -MD \
                 -D__ARM_ARCH_5__ \
                 -D__ARM_ARCH_5T__ \
                 -D__ARM_ARCH_5TE__ \
            "

export LINKFLAGS = "${LDFLAGS}"

SCONS_EXTRA_COMPILE_ARGS = "\
                arch=${TARGET_ARCH} \
                importenv=PATH,LINKFLAGS,V8_TARGET_ARCH_ARM \
                library=shared \
                soname=on \
                shlibtype=hidden \
        "

SCONS_EXTRA_INSTALL_ARGS = "${SCONS_EXTRA_COMPILE_ARGS}"

inherit scons

