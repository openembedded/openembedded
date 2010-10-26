# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Copyright (C) 2010, Adrian Alonso <aalonso00@gmail.com>
# Released under the MIT license (see packages/COPYING)
#
#This class handles all the intricasies of getting the required files from the
#ISE/EDK/project to the kernel and prepare the kernel for compilation.
#The Xilinx EDK supports 2 different architectures : PowerPC (ppc 405,440) and Microblaze
#Only the PowerPC BSP has been tested so far
#For this to work correctly you need to add XILINX_BSP_PATH and XILINX_BOARD to your 
#local.conf
#XILINX_BSP_PATH should have the complete path to your project dir
#XILINX_BOARD should have the board type i.e ML403
#
#Currently tested on
#Xilinx ML405
#Xilinx ML507
#More to come soon ;)

def map_target(a, d):
	import re
	board = bb.data.getVar('XILINX_BOARD', d, 1)
	cpu = bb.data.getVar('TARGET_CPU', d, 1)

	if re.match('powerpc', a):
		return 'ppc' + cpu + '-' + board
	else:
		return 'system'

def uboot_machine(a, d):
    import re

    board = bb.data.getVar('XILINX_BOARD', d, 1)
    if board in ['ml300', 'ml401', 'ml403', 'ml405', 'ml507', 'ml510']:
        if re.match('powerpc', a):
            if board == 'ml403':
                return 'ml401_config'
            elif board == 'ml510':
                return 'ml507_config'
            else:
                return board + '_config'
        else:
            return 'microblaze-generic_config'

def uboot_target(a, d):
    import re

    board = bb.data.getVar('XILINX_BOARD', d, 1)
    target = bb.data.getVar('TARGET_CPU', d, 1) + '-generic'
    if board in ['ml300', 'ml401', 'ml403', 'ml405', 'ml507', 'ml510']:
        if re.match('powerpc', a):
            if board == 'ml403':
                return 'ml401'
            elif board == 'ml510':
                return 'ml507'
            else:
                return board
        else:
            return target

do_configure_prepend() {
#first check that the XILINX_BSP_PATH and XILINX_BOARD have been defined in local.conf
#now depending on the board type and arch do what is nessesary
if [ -n "${XILINX_BSP_PATH}" ]; then
	if [ -n "${XILINX_BOARD}" ]; then
		if [ -d "${S}/arch/${TARGET_ARCH}/boot" ]; then
			dts=`find "${XILINX_BSP_PATH}" -name *.dts -print`
			if [ -e "$dts" ]; then
				oenote "Replacing device tree to match hardware model"
				if [ "${TARGET_ARCH}" = "powerpc" ]; then
					cp -pP ${dts} ${S}/arch/powerpc/boot/dts/virtex${TARGET_BOARD}.dts
				else
					cp -pP ${dts} ${S}/arch/microblaze/platform/generic/${TARGET_BOARD}.dts
				fi
			else
				oefatal "No device tree found, missing hardware ref design?"
				exit 1
			fi
		elif [ -d "${S}/board/xilinx" ]; then
			oenote "Replacing xparameters header to match hardware model"
			if [ "${TARGET_ARCH}" = "powerpc" ]; then
				xparam="${XILINX_BSP_PATH}/ppc${TARGET_CPU}_0/include/xparameters.h"
				cpu="PPC`echo ${TARGET_CPU} | tr '[:lower:]' '[:upper:]'`"
			else
				xparam="${XILINX_BSP_PATH}/${TARGET_CPU}_0/include/xparameters.h"
				cpu=`echo ${TARGET_CPU} | tr '[:lower:]' '[:upper:]'`
			fi
			if [ -e "$xparam" ]; then
				cp ${xparam} ${S}/board/xilinx/${UBOOT_TARGET}
				echo "/*** Cannonical definitions ***/
#define XPAR_PLB_CLOCK_FREQ_HZ XPAR_PROC_BUS_0_FREQ_HZ
#define XPAR_CORE_CLOCK_FREQ_HZ XPAR_CPU_${cpu}_CORE_CLOCK_FREQ_HZ
#ifndef XPAR_DDR2_SDRAM_MEM_BASEADDR
# define XPAR_DDR2_SDRAM_MEM_BASEADDR XPAR_DDR_SDRAM_MPMC_BASEADDR
#endif
#define XPAR_PCI_0_CLOCK_FREQ_HZ    0" >> ${S}/board/xilinx/${UBOOT_TARGET}/xparameters.h
			else
				oefatal "No xparameters header file found, missing hardware ref design?"
                exit 1
			fi
		fi
	else
		oefatal "XILINX_BOARD not defined ! Exit"
		exit 1
	fi
else
	oefatal "XILINX_BSP_PATH not defined ! Exit"
	exit 1
fi
}

do_deploy_prepend() {
# Install u-boot elf image
if [ -d "${XILINX_BSP_PATH}" ]; then
	if [ -e "${S}/u-boot" ]; then
		install ${S}/u-boot ${XILINX_BSP_PATH}
	fi
fi
}
