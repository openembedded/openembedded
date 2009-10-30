# uclibc:
require conf/distro/include/uclibc.inc

USE_NLS ?= "no"
USE_NLS_glib-2.0 = "yes"
USE_NLS_glib-2.0-native = "yes"
USE_NLS_gcc-cross = "no"

TARGET_OS_UC = "uclinux${@['-uclibc','-uclibceabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb3"
BUILD_OPTIMIZATION = "-O2 -ggdb3"

#Gcc will die with 'internal consistency error when using the above optimizations
FULL_OPTIMIZATION_avr32 = ""
BUILD_OPTIMIZATION_avr32 = ""

CXXFLAGS += "-fvisibility-inlines-hidden"

