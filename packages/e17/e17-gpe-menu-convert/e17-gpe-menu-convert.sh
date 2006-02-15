#!/bin/sh

setVar() {
    if [ ! "$value" = "" ]; then
        name=`echo "$name" | sed 'y:-\[\]:_____:'`
        value=`echo "$value" | sed 's:":\\\":g'`
        export $name="$value"
    fi
}

#convert true/false to 1/0
bool() {
    if [ ! "$1" = "" ]; then
        if [ "$1" = "True" ]; then
            cmd="$cmd $2 1"
        else
            cmd="$cmd $2 0"
        fi
    fi
}

str() {
    if [ ! "$1" = "" ]; then
        cmd="$cmd $2 \"$1"\"
    fi
}

convert_desktop_to_eap() {
    echo "Adding $1 to e menu"
    for l in `cat $1`; do
        #on empty line clear vars
        if [ "$l" = "" ]; then

            #grab previous var if it exists
            setVar

            name=""
            value=""
        else
            #if an = is in the line it's a name/value pair
            if echo "$l" | grep -q "="; then

                #grab previous var if it exists
                setVar

                name=`echo "$l" | cut -d "=" -f 1`
                value=`echo "$l" | cut -d "=" -f 2-`
            else

                #if previous value assume this is a continuation
                if [ ! "$value" = "" ]; then
                    value="$value $l"
                fi
            fi
        fi
    done
    setVar

    cmd=""

    #set up options
    bool "$StartupNotify" -set-startup-notify
    str "$Name" -set-name
    str "$Comment" -set-comment
    str "$Exec" -set-exe

    if [ ! "$cmd" = "" ]; then
        eapFile="$PATH_TO_EAP/$2"
        if [ -e $eapFile ]; then
            echo "EAP file for $2 already created";
        else
            echo "Converting $1 to $2"
            #cp ~/.e/e/applications/all/aterm.eap gpe-othello.eap
            ##empty out eap file
            ##enlightenment_eapp | grep -- -set- | cut -d " " -f 3 | xargs -iCMD enlightenment_eapp gpe-othello.eap CMD \"\"
            #enlightenment_eapp gpe-othello.eap -del-all

            cat <<EOF > /tmp/gpeEap.edc
images {
    image: "$Icon" COMP;
}
collections {
    group {
        name: "icon";
        max: 48 48;
        parts {
            part {
                name: "image";
                mouse_events: 0;
                description {
                    state: "default" 0.0;
                    aspect: 1.0 1.0;
                    image.normal: "$Icon";
                }
            }
        }
    }
}
EOF

            edje_cc --image_dir "$PATH_TO_PIXMAPS" /tmp/gpeEap.edc "$eapFile"
            rm /tmp/gpeEap.edc

            cmd="enlightenment_eapp \"$eapFile\" $cmd"

            #pipe command in sh to allow it to re-interpret quotes
            echo $cmd | /bin/sh -s
        fi

        if `echo "$Categories" | grep -q "SystemSettings"`; then
            dir="Settings"
        elif `echo "$Categories" | grep -q "PIM"`; then
            dir="PIM"
        elif `echo "$Categories" | grep -q "Network"`; then
            dir="Network"
        elif `echo "$Categories" | grep -q "Games"`; then
            dir="Games"
        elif `echo "$Categories" | grep -q "Game"`; then
            dir="Games"
        elif `echo "$Categories" | grep -q "AudioVideo"`; then
            dir="Multimedia"
        elif `echo "$Categories" | grep -q "Panel"`; then
            dir="Utility/Panel"
        elif `echo "$Categories" | grep -q "Utility"`; then
            dir="Utlity"
        else
            dir=""
        fi

        #dir=`echo "$Categories" | sed 'y:;:/:'`
        mkdir -p "$PATH_TO_E_GPE/$dir"
        orderFile="$PATH_TO_E_GPE/$dir"/.order
        add=1
        if [ -e "$orderFile" ]; then
            if grep -q "$2" "$orderFile"; then
                echo "$2 is already in the $dir menu"
                add=0
            fi
        fi
        if [ "$add" -eq 1 ]; then
            echo "Adding $2 to $dir menu"
            echo "$2" >> "$orderFile"
        fi
    fi
}

PATH_TO_DESKTOP="/usr/share/applications"
PATH_TO_PIXMAPS="/usr/share/pixmaps"
PATH_TO_EAP="/home/root/.e/e/applications/all"
PATH_TO_E_GPE="/home/root/.e/e/applications/favorite/GPE"

if [ ! -d $PATH_TO_E_GPE ]; then
    mkdir -p $PATH_TO_E_GPE
fi
if [ ! -d $PATH_TO_EAP ]; then
    mkdir -p $PATH_TO_EAP
fi
cd "$PATH_TO_DESKTOP"
for f in `ls *.desktop`; do
    eap=`echo "$f" | cut -d . -f 1`
    convert_desktop_to_eap "$PATH_TO_DESKTOP/$f" "$eap.eap"
done
