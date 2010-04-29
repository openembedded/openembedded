#!/bin/sh

machine_id() {          # return the machine ID
    awk 'BEGIN { FS=": " } /Hardware/ { gsub(" ", "_", $2); print tolower($2) } ' </proc/cpuinfo
}

if [ $# -ne 4 ] && [ $# -ne 6 ];
then
	echo "Usage:"
	echo ""
	echo "writeprom.sh vendorid deviceid rev fab_rev [envvar envsetting]"
	echo	
	echo " vendorid, deviceid - expansion board device number from http://www.elinux.org/BeagleBoardPinMux#Vendor_and_Device_IDs"
	echo
	echo " rev          - board revision (e.g. 0x00)"
	echo " fab_rev      - revision marking from pcb (e.g. R2411)"
	echo " envvar       - optional u-boot env variable name"
	echo "                (e.g. dvimode)"
	echo " envsetting   - optional u-boot env variable setting"
	echo "                (e.g. 1024x768MR-16@60)"
	echo
	echo "Don't forget to make the EEPROM writeable if it has a writeprotect jumper!"
	exit 1
fi

fabrevision=$4
if [ ${#fabrevision} -ge 8 ]; then
	echo "Error: fab revision string must less than 8 characters"
	exit 1
fi

envvar=$5
if [ ${#envar} -ge 16 ]; then
	echo "Error: environment variable name string must less than 16 characters"
	exit 1
fi

envsetting=$6
if [ ${#ensetting} -ge 64 ]; then
	echo "Error: environment setting string must less than 64 characters"
	exit 1
fi

case `machine_id` in                                                        
  "omap3_beagle_board")                                                         
      bus=2
      device=0x50
      ;;
  *)                                                              
      bus=3
      device=0x51
      ;;                                               
esac

device=0x50
vendorid=$1
if [ ${#vendorid} -ge 6 ]; then
    echo "Error: vendorid number must be less than 6 digits"
    exit 1
fi

i2cset -y $bus $device 0x00 0x00
i2cset -y $bus $device 0x01 $vendorid
i2cset -y $bus $device 0x02 0x00
i2cset -y $bus $device 0x03 $2
i2cset -y $bus $device 0x04 $3
i2cset -y $bus $device 0x05 00

let i=6
hexdumpargs="'${#fabrevision}/1 \"0x%02x \"'"
command="echo -n \"$fabrevision\" | hexdump -e $hexdumpargs"
hex=$(eval $command)
for character in $hex; do
	i2cset -y $bus $device $i $character
	let i=$i+1
done
i2cset -y $bus $device $i 0x00

if [ $# -eq 5 ]
then
	i2cset -y $bus $device 0x05 0x01

	let i=14
	hexdumpargs="'${#envvar}/1 \"0x%02x \"'"
	command="echo -n \"$envvar\" | hexdump -e $hexdumpargs"
	hex=$(eval $command)
	for character in $hex; do
		i2cset -y $bus $device $i $character
		let i=$i+1
	done
 	i2cset -y $bus $device $i 0x00

	let i=30
	hexdumpargs="'${#envsetting}/1 \"0x%02x \"'"
	command="echo -n \"$envsetting\" | hexdump -e $hexdumpargs"
	hex=$(eval $command)
	for character in $hex; do
		i2cset -y $bus $device $i $character
		let i=$i+1
	done	 
	i2cset -y $bus $device $i 0x00
fi

