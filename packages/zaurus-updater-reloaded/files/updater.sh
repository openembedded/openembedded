#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: updater.sh
# Date: 04-Nov-06
#
#########################################################################################
#
# How to add a new machine:
# - Add an entry in get_model() for the machine, using the parameters found in the machines 
#   original updater.sh
# - Set KERNEL_TYPES and ROOTFS_TYPES to the supported kernel and rootfs types: 
# - done ;)
#

SCRIPT_VERSION="0.0.0-developer-snapshot"
ENABLE_DEBUG=1

SRC_PATH=$1

C_RED="\033[31m"
C_WHITE="\033[38m"
C_RESET="\033[0m"

# Generic variables for Sharp's flashing code
TMPPATH=/tmp/update
TMPDATA=$TMPPATH/tmpdata.bin
TMPHEAD=$TMPPATH/tmphead.bin
RESULT=0
LOGOCAL_MTD=/dev/mtd1

# This is for debugging only
test -z "$SRC_PATH" && SRC_PATH="/mnt/cf"
test -e "$SRC_PATH/shell" && /bin/sh

die(){
	echo -e "$1"
	echo "Please reset."
	while true
	do
	done	
}

debug_echo(){
	test "$ENABLE_DEBUG" = 1 && echo -e "$1"
}

get_model(){
	# w/o writerominfo /proc/deviceinfo/product returns "unknown"
	/sbin/writerominfo
	PDA_MODEL=`cat /proc/deviceinfo/product`
	
	case "$PDA_MODEL" in
	SL-B500|SL-5600)	PDA_NAME="Poodle"
				KERNEL_TYPES="NAND"
				ROOTFS_TYPES="NAND sdimage"
				
				KERNEL_ISLOGICAL=1
				KERNEL_MODULEID=5
				KERNEL_MODULESIZE=0x13C000
				KERNEL_ADDR=`dc 0xE0000`
				KERNEL_ISFORMATTED=1
				KERNEL_DATAPOS=0
				KERNEL_ONESIZE=524288
				
				ROOTFS_ISLOGICAL=0
				ROOTFS_MODULEID=6
				ROOTFS_MODULESIZE=0x1600000
				ROOTFS_ADDR=0
				ROOTFS_ISFORMATTED=0				
				ROOTFS_DATAPOS=16
				ROOTFS_ONESIZE=1048576				
				;;
	*)			die "Error: Unknown model: [$PDA_MODEL]"
				;;
	esac
	
	echo "Found a $PDA_MODEL aka $PDA_NAME "
	echo -e "\nKernel types: $KERNEL_TYPES"
	echo -e "Rootfs types: $ROOTFS_TYPES"
	
	echo -e "\n------------------------------"
}

update_model(){
	for ktype in $KERNEL_TYPES
	do
		case "$ktype" in
		NAND)		update_nand_kernel;;
		esac
		
		echo -e "\n------------------------------"
	done
	
	for rtype in $ROOTFS_TYPES
	do
		case "$rtype" in
		NAND)		update_nand_rootfs;;
		sdimage)	update_sdimage_rootfs;;
		esac						
		
		echo -e "\n------------------------------"	
	done
}

update_sdimage_rootfs(){
	cd "$SRC_PATH"
		
	for sdimage_src in sdimage1.tgz sdimage1.TGZ SIMAGE1.TGZ
	do
		if test -e "$sdimage_src" -a -z "$SDIMAGE_ROOTFS_IS_DONE"
		then
			if ! ( mount | grep -q "^/dev/mmcda" )
			then
				echo ""
				echo "${C_RESET}Note: No SD card found!${C_WHITE}"
				return
			fi

			if ! test -e ./gnu-tar
			then
				echo ""
				echo "${C_RESET}Note: gnu-tar is missing!${C_WHITE}"
				return
			fi
		
			echo ""
			echo "Updating SD/MMC rootfs"

			echo ""
			echo -e "Do you want me to format \nthe first partition of \nyour SD/MMC card?"
			echo -e "\nPlease note that this"
			echo -e "a) is optional"
			echo -e "b) will destroy any data on \n   that partition"
			echo -e ""
			
			while true
			do
				echo -n "Format? [y|N]: "			
				read junk
				
				case "$junk" in
				y|Y)	SD_FORMAT=yes
					break ;;
				n|N|"")	SD_FORMAT=no
					break ;;					
				esac
			done
			
			if test "$SD_FORMAT" = yes
			then
				umount /dev/mmcda1 >/dev/null 2>&1
				echo ""
				echo -n "Formatting to ext2..."
				
				if ! mkfs.ext2 -m0 /dev/mmcda1 >/dev/null 2>&1 				
				then
					echo FAILED
					die "mkfs.ext2 -m0 /dev/mmcda1 FAILED"
				else	
					echo -e "done\n"
				fi
			else
				echo -e "\nRemoving directories of your \nold installation:"
				
				echo -n "*"
				for dir in bin dev media proc sys usr boot etc lib mnt sbin tmp var
				do
					echo -n " $dir"
					test -e "/mnt/card/$dir" && rm -rf "/mnt/card/$dir"
				done
				
				echo " *"
			fi
			
			# Well, as a last resort, rely on SHARPs auto-mounter
			if test -e /mnt/card/NotAvailable
			then
				echo -e "\nPlease eject the SD/MMC \ncard and re-insert it."
				echo "Press <ENTER> when finished"
				read junk
				sleep 2
			fi				
			
			if test -e /mnt/card/NotAvailable
			then
				echo ""
				echo "Couldn't mount SD/MMC card!"
			else
				echo -e "\nExtracting $sdimage_src \nThis can take up to 30m!"
				./gnu-tar -C /mnt/card -xzf ./$sdimage_src
			fi
						
			SDIMAGE_ROOTFS_IS_DONE=1
		fi				
	done
	
	test -z "$SDIMAGE_ROOTFS_IS_DONE" && echo -e "\nNote: No SD/MMC rootfs found!"
}

update_nand_kernel(){	
	cd "$SRC_PATH"
	
	# Please note that zImage and zimage are the same on FAT16...
	for kernel_src in zImage zimage zImage.bin zimage.bin
	do
		if test -e "$kernel_src" -a -z "$NAND_KERNEL_IS_DONE"
		then
			echo ""
			echo "Updating NAND kernel"
			
			rm -f $TMPPATH/*.bin > /dev/null 2>&1
			DATASIZE=`wc -c $kernel_src`
			DATASIZE=`echo $DATASIZE | cut -d' ' -f1`
			HDTOP=`expr $DATASIZE - 16`
			/sbin/bcut -a $HDTOP -s 16 -o $TMPHEAD $kernel_src
			
			generic_flash "$KERNEL_ISLOGICAL" "$KERNEL_MODULEID" "$KERNEL_MODULESIZE" \
					"$KERNEL_ADDR" "$KERNEL_ISFORMATTED" "$KERNEL_DATAPOS" "$KERNEL_ONESIZE" "$kernel_src"
			
			NAND_KERNEL_IS_DONE=1
		fi
	done
	
	test -z "$NAND_KERNEL_IS_DONE" && echo -e "\nNote: No NAND kernel found!"
}

update_nand_rootfs(){
	cd "$SRC_PATH"

	RO_MTD_LINE=`cat /proc/mtd | grep "root" | tail -n 1`
	if [ "$RO_MTD_LINE" = "" ]; then
	    RO_MTD_LINE=`cat /proc/mtd | grep "\<NAND\>.*\<2\>" | tail -n 1`
	fi
	RO_MTD_NO=`echo $RO_MTD_LINE | cut -d: -f1 | cut -dd -f2`
	RO_MTD_SIZE_HEX=`echo $RO_MTD_LINE | cut -d" " -f2`
	RO_MTD=/dev/mtd$RO_MTD_NO
	RO_MTDBLK=/dev/mtdblock$RO_MTD_NO
	RO_MTD_SIZE=`dc 0x$RO_MTD_SIZE_HEX 1024 /`

	LOGOCAL_MTD=/dev/mtd1
	
	# Please note that initrd.BIN and initrd.bin are the same on FAT16...
	for rootfs_src in initrd.bin initrd.BIN
	do
		if test -e "$rootfs_src" -a -z "$NAND_ROOTFS_IS_DONE"
		then
			echo ""
			echo "Updating NAND rootfs"
			
			rm -f $TMPPATH/*.bin > /dev/null 2>&1
			DATASIZE=`wc -c $rootfs_src`
			DATASIZE=`echo $DATASIZE | cut -d' ' -f1`
			
			TARGET_MTD=$RO_MTD
			/sbin/bcut -s 16 -o $TMPHEAD $rootfs_src
			
			generic_flash "$ROOTFS_ISLOGICAL" "$ROOTFS_MODULEID" "$ROOTFS_MODULESIZE" \
					"$ROOTFS_ADDR" "$ROOTFS_ISFORMATTED" "$ROOTFS_DATAPOS" "$ROOTFS_ONESIZE" "$rootfs_src"
			
			NAND_ROOTFS_IS_DONE=1
		fi
	done
	
	test -z "$NAND_ROOTFS_IS_DONE" && echo -e "\nNote: No NAND rootfs found!"
}

# The following function is almost a 1-to-1 copy from Sharps updater.sh for Poodle
# Guess why....
generic_flash(){
		ISLOGICAL="$1"
		MODULEID="$2"
		MODULESIZE="$3"
		ADDR="$4"
		ISFORMATTED="$5"
		DATAPOS="$6"
		ONESIZE="$7"
		TARGETFILE="$8"

		#check version
		/sbin/bcut -s 6 -o $TMPDATA $TMPHEAD
		if [ `cat $TMPDATA` != "SHARP!" ] > /dev/null 2>&1
		then
			#no version info...
			rm -f $TMPHEAD > /dev/null 2>&1
			DATAPOS=0
		fi

		#format?
		if [ $ISFORMATTED = 0 ]
		then
			echo ""
			echo -n "Flash erasing..."
			/sbin/eraseall $TARGET_MTD 2> /dev/null > /dev/null
			
			echo 'done'
			ISFORMATTED=1
		fi
		
		echo ''
		echo '0%                   100%'
		PROGSTEP=`expr $DATASIZE / $ONESIZE + 1`
		PROGSTEP=`expr 25 / $PROGSTEP`
		if [ $PROGSTEP = 0 ]
		then
			PROGSTEP=1
		fi

		#header information
		if [ -e $TMPHEAD ]
		then
			VTMPNAME=$TMPPATH'/vtmp'`date '+%s'`'.tmp'
			MTMPNAME=$TMPPATH'/mtmp'`date '+%s'`'.tmp'
			/sbin/nandlogical $LOGOCAL_MTD READ $VERBLOCK 0x4000 $VTMPNAME > /dev/null 2>&1
			/sbin/nandlogical $LOGOCAL_MTD READ $MVRBLOCK 0x4000 $MTMPNAME > /dev/null 2>&1

			#echo 'found header'
			/sbin/verchg -v $VTMPNAME $TMPHEAD $MODULEID $MODULESIZE > /dev/null 2>&1
			/sbin/verchg -m $MTMPNAME $TMPHEAD $MODULEID $MODULESIZE > /dev/null 2>&1
		fi

		#loop
		while [ $DATAPOS -lt $DATASIZE ]
		do
			#data create
			bcut -a $DATAPOS -s $ONESIZE -o $TMPDATA $TARGETFILE
			TMPSIZE=`wc -c $TMPDATA`
			TMPSIZE=`echo $TMPSIZE | cut -d' ' -f1`
			DATAPOS=`expr $DATAPOS + $TMPSIZE`

			#handle data file
			#echo 'ADDR='$ADDR
			#echo 'SIZE='$TMPSIZE
			if [ $ISLOGICAL = 0 ]
			then
				next_addr=`/sbin/nandcp -a $ADDR $TMPDATA $TARGET_MTD  2>/dev/null | fgrep "mtd address" | cut -d- -f2 | cut -d\( -f1`
				if [ "$next_addr" = "" ]; then
					echo "ERROR:flash write"
					rm $TMPDATA > /dev/null 2>&1
					RESULT=3
					break;
				fi
				ADDR=$next_addr
			else
				/sbin/nandlogical $LOGOCAL_MTD WRITE $ADDR $DATASIZE $TMPDATA > /dev/null 2>&1
				ADDR=`expr $ADDR + $TMPSIZE`
			fi

			rm $TMPDATA > /dev/null 2>&1

			#progress
			SPNUM=0
			while [ $SPNUM -lt $PROGSTEP ]
			do
				echo -n '.'
				SPNUM=`expr $SPNUM + 1`
			done
		done

		echo ''

		rm -f $TMPPATH/*.bin > /dev/null 2>&1

		if [ $RESULT = 0 ]
		then
			if [ -e $VTMPNAME ]
			then
				/sbin/nandlogical $LOGOCAL_MTD WRITE $VERBLOCK 0x4000 $VTMPNAME > /dev/null 2>&1
				rm -f $VTMPNAME > /dev/null 2>&1
			fi
			if [ -e $MTMPNAME ]
			then
				/sbin/nandlogical $LOGOCAL_MTD WRITE $MVRBLOCK 0x4000 $MTMPNAME > /dev/null 2>&1
				rm -f $MTMPNAME > /dev/null 2>&1
			fi
			echo 'Success!'
		else
			echo 'Error!'
#			exit $RESULT
		fi

}

cleanup(){
	rm -f $VTMPNAME > /dev/null 2>&1
	rm -f $MTMPNAME > /dev/null 2>&1
	rm $CTRLPATH/* > /dev/null 2>&1
	rm $DATAPATH/* > /dev/null 2>&1	
}

main(){
	clear
	echo -e "${C_WHITE}\nupdater.sh reloaded v${SCRIPT_VERSION}"
	echo -e "------------------------------\n"
	get_model
	update_model 
	
	cleanup
	
	die "\n\nUpdate finished.${C_RESET}"
}


main
