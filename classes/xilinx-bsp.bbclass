# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
#
#This class handles all the intricasies of getting the required files from the 
#ISE/EDK/project to the kernel and prepare the kernel for compilation.
#The Xilinx EDK supports 2 different architectures : PowerPC (ppc 405) and Microblaze
#Only the PowerPC BSP has been tested so far
#For this to work correctly you need to add XILINX_BSP_PATH and XILINX_BOARD to your 
#local.conf
#XILINX_BSP_PATH should have the complete path to your project dir
#XILINX_BOARD should have the board type i.e ML403
#
#Currently supported boards
#Xilinx ML403
#More to come soon ;)

do_configure_prepend() {


#first check that the XILINX_BSP_PATH and XILINX_BOARD have been defined in local.conf
if [ -z "${XILINX_BSP_PATH}" ]; then
   oefatal "XILINX_BSP_PATH not defined ! Exiting..."
   exit 1

else
   if [ -z "${XILINX_BOARD}" ]; then
      oefatal "XILINX_BOARD not defined ! Exiting"
      exit 1
   fi

fi
#now depending on the board type and arch do what is nessesary

case "${XILINX_BOARD}" in
     ML403)
        oenote "ML403 board setup"
        cp -pPR ${XILINX_BSP_PATH}/ppc405_0/libsrc/linux_2_6_v1_00_a/linux/arch/ppc/platforms/4xx/xparameters/xparameters_ml40x.h \
                ${S}/arch/ppc/platforms/4xx/xparameters/xparameters_ml403.h
     ;;

     *    ) 
      oefatal "! Unknow Xilinx board ! Exiting..."
      exit 1
     ;;
esac               


}





