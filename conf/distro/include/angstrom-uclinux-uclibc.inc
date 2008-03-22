# uclibc:
#fix some iconv issues, needs to be adjusted when doing uclibc builds
PREFERRED_PROVIDER_virtual/libc = "uclibc"
PREFERRED_PROVIDER_virtual/libiconv ?= "libiconv"
PREFERRED_PROVIDER_virtual/libintl ?= "gettext"

USE_NLS ?= "no"
USE_NLS_glib-2.0 = "yes"

TARGET_OS_UC = "uclinux${@['-uclibc','-uclibcgnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb'] and bb.data.getVar('MACHINE',d) not in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
BUILD_OPTIMIZATION = "-Os"

#Gcc will die with 'internal consistency error when using the above optimizations
FULL_OPTIMIZATION_avr32 = ""
BUILD_OPTIMIZATION_avr32 = ""

CXXFLAGS += "-fvisibility-inlines-hidden"

