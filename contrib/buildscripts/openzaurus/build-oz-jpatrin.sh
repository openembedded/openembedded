for machine in spitz poodle akita borzoi c7x0 tosa collie;
do
        rm conf/auto.conf
        echo "MACHINE = \"$machine\"" > conf/auto.conf
        echo "MACHINE = \"$machine\""

        [ -e script ] && rm script
        #echo "rebuild virtual/kernel; exit" > script
        echo "rebuild initscripts; rebuild sysvinit; rebuild tslib; rebuild altboot; build bootstrap-image; build gpe-image; build e-image-core; build e-image; rebuild virtual/libqte2; rebuild virtual/libqpe; rebuild opie-button-settings; build opie-image; exit" > script
        bitbake -i < script
done

rm script