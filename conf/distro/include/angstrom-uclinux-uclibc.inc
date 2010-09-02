# uclibc:
require conf/distro/include/uclibc.inc

USE_NLS ?= "no"
USE_NLS_glib-2.0 = "yes"
USE_NLS_glib-2.0-native = "yes"
USE_NLS_gcc-cross = "no"

TARGET_OS_UC = "uclinux${@['-uclibc','-uclibceabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb']]}"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb2"
BUILD_OPTIMIZATION = "-O2"

#Gcc will die with 'internal consistency error when using the above optimizations
FULL_OPTIMIZATION_avr32 = ""
BUILD_OPTIMIZATION_avr32 = ""

CXXFLAGS += "-fvisibility-inlines-hidden"

