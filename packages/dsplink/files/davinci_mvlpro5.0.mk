#   ============================================================================
#   @file   davinci_mvlpro5.0.mk
#
#   @path   $(DSPLINK)/make/Linux/
#
#   @desc   This makefile defines OS specific macros used by MAKE system for
#           the Montavista Pro 5.0 Linux distribution.
#
#   @ver    1.50
#   ============================================================================
#   Copyright (c) Texas Instruments Incorporated 2002-2007
#
#   Use of this software is controlled by the terms and conditions found in the
#   license agreement under which this software has been supplied or provided.
#   ============================================================================


ifndef DAVINCI_MVLPRO5_0_MK

define DAVINCI_MVLPRO5_0_MK
endef


#   ============================================================================
#   Let the make system know that a specific distribution for the GPP OS
#   is being used.
#   ============================================================================
USE_DISTRIBUTION := 1


#   ============================================================================
#   Set the values of necessary variables to be used for the OS.
#   ============================================================================

#   ----------------------------------------------------------------------------
#   Base directory for the GPP OS
#   ----------------------------------------------------------------------------
BASE_BUILDOS    := SED_ME_KERNELDIR

#   ----------------------------------------------------------------------------
#   Base for code generation tools - compiler, linker, archiver etc.
#   ----------------------------------------------------------------------------
BASE_CGTOOLS    := /opt/montavista/pro/devkit/arm/v5t_le/bin

#   ----------------------------------------------------------------------------
#   Base directory for include files provided by GPP OS
#   ----------------------------------------------------------------------------
BASE_OSINC      := $(BASE_BUILDOS)/include

OSINC_GENERIC   := $(BASE_OSINC)
OSINC_PLATFORM  := SED_ME_CROSS/4.2.0/include
OSINC_TARGET    := SED_ME_STAGINGDIR/usr/include

ifneq ("$(VARIANT)", "")
OSINC_VARIANT   := $(BASE_OSINC)
endif


#   ----------------------------------------------------------------------------
#   Base directory for libraries provided by GPP OS
#   ----------------------------------------------------------------------------
BASE_OSLIB      := SED_ME_STAGINGDIR/lib

OSLIB_GENERIC   := $(BASE_OSLIB)
OSLIB_PLATFORM  := $(BASE_OSLIB)


ifneq ("$(VARIANT)", "")
OSLIB_VARIANT   := $(BASE_OSLIB)
endif


#   ============================================================================
#   COMPILER
#   ============================================================================

#   ----------------------------------------------------------------------------
#   Name of the compiler
#   ----------------------------------------------------------------------------
COMPILER        := SED_ME_TARGET_PREFIXgcc
LD              := SED_ME_TARGET_PREFIXld

CROSS_COMPILE   := SED_ME_TARGET_PREFIX
export CROSS_COMPILE

#   ----------------------------------------------------------------------------
#   Command line switches used by the compiler
#
#   CC_SW_DEF       Command line defines
#   CC_SW_INC       Search path for header files
#   CC_SW_OBJ       Create object file
#   CC_SW_DEB       Include debug information
#   ----------------------------------------------------------------------------
CC_SW_DEF       := -D
CC_SW_INC       := -I
CC_SW_OBJ       := -o
CC_SW_DEB       := -g

#   ----------------------------------------------------------------------------
#   Standard flags for the compiler
#   ----------------------------------------------------------------------------
STD_KRNL_FLAGS  := -include linux/autoconf.h -c -iwithprefix include -Iinclude -Wall  -Wstrict-prototypes\
                   -Wno-trigraphs -fno-strict-aliasing -fno-common             \
                   -fno-omit-frame-pointer -mapcs -mno-sched-prolog            \
                   -mlittle-endian -D__LINUX_ARM_ARCH__=5 -march=armv5t        \
                   -mtune=arm9tdmi  -msoft-float -Uarm -mapcs                  \
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux
STD_USER_FLAGS  := -mlittle-endian -march=armv5t -mtune=arm9tdmi  -msoft-float \
                  -Uarm -Wdeclaration-after-statement -marm -Wall              \
                  -Wstrict-prototypes -Wno-trigraphs -fno-strict-aliasing      \
                  -fno-common -fno-omit-frame-pointer -mapcs -c                \
                  -mabi=aapcs-linux

#   ----------------------------------------------------------------------------
#   Standard flags for the compiler when building an executable
#   ----------------------------------------------------------------------------
EXE_CC_FLAGS    :=

#   ----------------------------------------------------------------------------
#   Flags for the compiler when building a driver
#   ----------------------------------------------------------------------------
DRV_CC_FLAGS    := -nostdinc

#   ----------------------------------------------------------------------------
#   Flags for the compiler when building a library
#   ----------------------------------------------------------------------------
LIB_CC_FLAGS    :=

#   ----------------------------------------------------------------------------
#   Standard definitions for the compiler
#   ----------------------------------------------------------------------------
STD_CC_DEFNS    := -D_REENTRANT


#   ============================================================================
#   ARCHIVER1 - This denotes the linker.
#   ============================================================================
ARCHIVER1        := SED_ME_TARGET_PREFIXld

#   ----------------------------------------------------------------------------
#   Standard flags for the archiver
#   ----------------------------------------------------------------------------
STD_AR_FLAGS1    := -EL -r


#   ============================================================================
#   ARCHIVER2 - This denotes the archiver.
#   ============================================================================
ARCHIVER2        := SED_ME_TARGET_PREFIXar

#   ----------------------------------------------------------------------------
#   Standard flags for the archiver
#   ----------------------------------------------------------------------------
STD_AR_FLAGS2    := -r


#   ============================================================================
#   LINKER - The compiler is used for linking purpose as well.
#   ============================================================================
LINKER      := SED_ME_TARGET_PREFIXgcc

#   ----------------------------------------------------------------------------
#   Command line switches used by the linker
#
#   LD_SW_LIB       Search path for libraries
#   LD_SW_OUT       Output filename
#   LD_SW_RELOC     Generate relocateable output
#   ----------------------------------------------------------------------------
LD_SW_LIB       := -L
LD_SW_OUT       := -o
LD_SW_RELOC     := -r

#   ----------------------------------------------------------------------------
#   Standard flags for the linker
#   ----------------------------------------------------------------------------
STD_LD_FLAGS    :=

#   ----------------------------------------------------------------------------
#   Specific flags for the linker if linking and module generating utility are
#   different
#   ----------------------------------------------------------------------------
SPECIFIC_LD_FLAGS    :=  -lpthread

#   ----------------------------------------------------------------------------
#   Flags for the linker when building an executable
#   ----------------------------------------------------------------------------
EXE_LD_FLAGS    := -lc

#   ----------------------------------------------------------------------------
#   Flags for the linker when building a driver
#   ----------------------------------------------------------------------------
DRV_LD_FLAGS    :=


#   ============================================================================
#   Post processing utilities for Linux 2.6
#   ============================================================================
CMD_MODPOST     := $(BASE_BUILDOS)/scripts/mod/modpost -i $(BASE_BUILDOS)/Module.symvers $(BASE_BUILDOS)/vmlinux


endif   # ifndef DAVINCI_MVLPRO5_0_MK
