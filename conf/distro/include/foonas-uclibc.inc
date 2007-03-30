# uclibc:
#fix some iconv issues, needs to be adjusted when doing uclibc builds
PREFERRED_PROVIDER_virtual/libc = "uclibc"
PREFERRED_PROVIDER_virtual/libiconv ?= "libiconv"
PREFERRED_PROVIDER_virtual/libintl ?= "gettext"

USE_NLS ?= "no"

TARGET_OS = "linux${@['-uclibc','-uclibcgnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
BUILD_OPTIMIZATION = "-Os"
CXXFLAGS += "-fvisibility-inlines-hidden"

SRCDATE_uclibc ?= "20070320"
PREFERRED_VERSION_uclibc ?= "0.9.28+svn${SRCDATE_uclibc}"
PREFERRED_VERSION_uclibc-initial ?= "0.9.28+svn${SRCDATE_uclibc}"

PREFERRED_VERSION_linux-libc-headers    = "2.6.18"
#PREFERRED_VERSION_linux-libc-headers_powerpc = "2.6.15.99"