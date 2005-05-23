//=============================================================================
//
// n2-io.c version 0.1.7
// Author: Karen Spearel <kas11 at tampabay.rr.com>
// please report problems/bugs directly to the address above
//
// Boilerplate to be added "real soon now"...it is and has always been GPL'ed per
// MODULE_LICENSE but is offered without warrantee of any sort..use at your own risk
//
// NOTE: THIS IS INCOMPLETE.  INCLUDED ONLY TO KEEP FROM BREAKING THE BUILD,
// IT BEEPS AND SENDS A MESSAGE TO /proc/poweroff.  EVENTUALLY IT
// WILL TALK TO THE n2_pbd DAEMON.  EVENTUALLY THE LED DRIVER
// WILL TALK TO SOME USERLAND APP BUT ***NOT*** SET_LEDS.
// 
//=============================================================================
//	GPIO		Function	State
//	0		Red LED		Status		
//	1		Green LED	Ready = 1
//	2		Disk 2 LED	On = 0
//	3		Disk 1 LED	On = 0
//	4		Buzzer
//	5		Power Button	Pressed = 1
//	8		Power Down	Output = 1 powers down N2
//	12		Reset		Pressed = 0
//=============================================================================
// this driver is N2 specific and is purposely designed to do the minimum 
// necessary to provide the necessary services given the limited memory resources
// of the N2.  As OpenN2 develops, addition features will be added as
// suggested by the community.
//
//=============================================================================

#include <linux/config.h>
#include <linux/version.h>
#include <linux/module.h>
#include <linux/utsname.h>
#include <linux/kernel.h>
#include <linux/major.h>
#include <linux/string.h>
#include <linux/proc_fs.h>
#include <linux/slab.h>
#include <linux/init.h>
#include <linux/errno.h>
#include <linux/fs.h>
#include <linux/miscdevice.h>
#include <linux/device.h>
#include <linux/interrupt.h>
#include <linux/moduleparam.h>
#include <linux/timer.h>

#include <asm/system.h>
#include <asm/uaccess.h>
#include <asm/hardware.h>
#include <asm-arm/irq.h>
#include <asm-arm/delay.h>
#include <asm-arm/signal.h>


#define VERSION			"0.1.7"

#define N2RB_MAJOR		60
#define N2PB_MAJOR		61
#define	N2BZ_MAJOR		62
#define N2LM_MAJOR		126

#define N2PB_IRQ		22		//gpio5
#define	N2RB_IRQ		29		//gpio12

#define N2_BEEP_DUR_LONG	2000
#define N2_BEEP_DUR_MED		400
#define N2_BEEP_DUR_SHORT	100
#define N2_BEEP_PITCH_HIGH	250
#define N2_BEEP_PITCH_MED	500
#define N2_BEEP_PITCH_LOW	1000
#define N2_LONG_DELAY		30000

#define N2_BZ_GPIO		4
#define N2_PB_GPIO		5
#define N2_PO_GPIO		8		//power off
#define N2_RB_GPIO		12

#define GPIO_BZ_BM		0x0010	//b0000 0000 0001 0000
#define GPIO_PB_BM		0x0020	//b0000 0000 0010 0000
#define GPIO_PO_BM		0x0100  //b0000 0001 0000 0000
#define GPIO_RB_BM		0x1000	//b0001 0000 0000 0000

#define NOERR			0

#define RB_DELAY		50
#define PB_DELAY		20

#define PWR_OFF_STR		"poweroff"


// ioctls -- 'M" is used for sound cards...we don't got one so it seems safe

#define N2BZ_BEEP_STOP		_IO('M',0)       //stop multi-beep at end of audible
#define N2BZ_BEEP		_IO('M',1)       //one beep at current defaults
#define N2BZ_BEEPS		_IOW('M',3,long) //param beeps at current defaults
#define N2BZ_TONESET		_IOW('M',4,long) //set tone: range is high=250 to low=2000
#define N2BZ_ONTIME		_IOW('M',5,long) //ontime for multi-beeps in jiffies
#define	N2BZ_SILENTTIME		_IOW('M',6,long) //offtime for multi-beeps in jiffies
#define N2BZ_REPEATCNT		_IOW('M',7,long) //number of repeats for multi-beeps 0 = forever
#define N2BZ_COMBINED		_IOW('M',8,long) //combine all params in a long

#define N2LM_OFF		_IOW('M',32,long)
#define N2LM_ON			_IOW('M',33,long)
#define N2LM_BLINK		_IOW('M',34,long)
#define N2LM_ALT		_IOW('M',35,long)
#define N2LM_ALL_ON		_IO('M',36)
#define N2LM_ALL_OFF		_IO('M',37)

#define PHYS_LEDS		4
#define BLINK_DELAY		25

//  OR Masks to turn these LEDs ON

#define	RS_RED_ON	0x00000001	//0b0000 0000 0000 0010
#define	RS_GRN_ON	0x00000002	//0b0000 0000 0000 0001
#define RS_YEL_ON	0x00000003	//0b0000 0000 0000 0011

// AND Masks to turn these LEDs OFF

#define	RS_RED_OFF	0xfffffffe	//0b1111 1111 1111 1101
#define	RS_GRN_OFF	0xfffffffd	//0b1111 1111 1111 1110
#define RS_YEL_OFF	0xfffffffc	//0b1111 1111 1111 1100

// AND Masks to turn these LEDs ON

#define DISK1_ON	0xfffffff7	//0b1111 1111 1111 0111
#define	DISK2_ON	0xfffffffb	//0b1111 1111 1111 1011

// Or Masks to turn these LEDs OFF

#define DISK1_OFF	0x00000008	//0b0000 0000 0000 1000
#define	DISK2_OFF	0x00000004	//0b0000 0000 0000 0100	

// EOR masks for toggling LEDs on/off

#define RS_RG_ALT	0x00000003	//eor mask to toggle rs rg bits
#define RS_GRN_TGL	0x00000002
#define RS_RED_TGL	0x00000001
#define DISK1_TGL	0x00000008
#define DISK2_TGL	0x00000004

// The LED names for switches

#define LED_RS_RED	0
#define LED_RS_GRN	1
#define	LED_DISK1	2
#define LED_DISK2	3
#define LED_ALL		4

static unsigned long init_jiffy = 0;			//jiffies at init time
static unsigned long rb_presses = 0;			//number of reset button presses
static unsigned long ontime = 50;
static unsigned long offtime = 450;
static unsigned long bz_repeatcnt = 10;
static unsigned long tone = 1000;

DECLARE_WAIT_QUEUE_HEAD(n2rb_waitq);
DECLARE_WAIT_QUEUE_HEAD(n2pb_waitq);

static struct timer_list n2lm_rsg_timer;	//rs green 
static struct timer_list n2lm_rsr_timer;	//rs red
static struct timer_list n2lm_d1_timer;		//drive 1
static struct timer_list n2lm_d2_timer;		//drive 2
static struct timer_list n2rb_timer;
static struct timer_list n2pb_timer;
static struct timer_list n2bz_timer;		//beeper

//==================================================================================================
//
// Blinking is handled entirely by the 4 timer handlers.  On timeout, the bit in the
// GPIO output register is xor'd with a mask corresponding to the selected led which simply
// flips that bit.  No record of what any of the other leds is doing is needed.
//
//==================================================================================================
// this blinks rs green or green/yellow if rs red is on
static void n2lm_rsg_handler(unsigned long data)
{
	*IXP4XX_GPIO_GPOUTR ^= RS_GRN_TGL;			//flip the led
	n2lm_rsg_timer.expires = jiffies + BLINK_DELAY;		//next timeout
	add_timer(&n2lm_rsg_timer);				//reinit timer
	return;
}

// this blinks or alternates rs red green... inited wit green on/red off
static void n2lm_rsr_handler(unsigned long data)
{
	*IXP4XX_GPIO_GPOUTR ^= n2lm_rsr_timer.data;
	n2lm_rsr_timer.expires = jiffies + BLINK_DELAY;
	add_timer(&n2lm_rsr_timer);
	return;	
}
// blinks disk 1
static void n2lm_d1_handler(unsigned long data)
{
	*IXP4XX_GPIO_GPOUTR ^= DISK1_TGL;
	n2lm_d1_timer.expires = jiffies + BLINK_DELAY;
	add_timer(&n2lm_d1_timer);
	return;
}
// blinks disk 2
static void n2lm_d2_handler(unsigned long data)
{
	*IXP4XX_GPIO_GPOUTR ^= DISK2_TGL;
	n2lm_d2_timer.expires = jiffies + BLINK_DELAY;
	add_timer(&n2lm_d2_timer);
	return;
}

//==================================================================================================

static void n2lm_timer_start(unsigned long led)
{

	printk(KERN_DEBUG "timer: %ld\n",led);

	switch(led) {
		case LED_RS_RED:
			n2lm_rsr_timer.expires = jiffies + BLINK_DELAY;
			add_timer(&n2lm_rsr_timer);
			break;

		case LED_RS_GRN:
			n2lm_rsg_timer.expires = jiffies + BLINK_DELAY;
			add_timer(&n2lm_rsg_timer);
			break;

		case LED_DISK1:
			n2lm_d1_timer.expires = jiffies + BLINK_DELAY;
			add_timer(&n2lm_d1_timer);
 			break;

		case LED_DISK2:
			n2lm_d2_timer.expires = jiffies + BLINK_DELAY; 
			add_timer(&n2lm_d2_timer);
			break;

		default:
			break;
	}
	return;
}

//==================================================================================================

static void n2lm_timer_stop(unsigned long led)
{
	switch (led) {
		case LED_RS_RED:
			del_timer(&n2lm_rsr_timer);
			break;
		case LED_RS_GRN:
			del_timer(&n2lm_rsg_timer);
			break;
		case LED_DISK1:
			del_timer(&n2lm_d1_timer);
 			break;
		case LED_DISK2: 
			del_timer(&n2lm_d2_timer);
			break;
		default:
			break;
	}
	return;
}

//--------------------------------------------------------------------------------------------------

static void n2lm_timer_stop_all(void)
{
	del_timer(&n2lm_rsg_timer);
	del_timer(&n2lm_rsr_timer);
	del_timer(&n2lm_d1_timer); 
	del_timer(&n2lm_d2_timer);
	return;
}
//--------------------------------------------------------------------------------------------------

static void n2lm_ledon(unsigned long led)
{

	printk(KERN_DEBUG "ledon: %ld\n", led);

	switch (led) {
		case LED_RS_RED:	
			*IXP4XX_GPIO_GPOUTR |= RS_RED_ON;	//1
			return;
		case LED_RS_GRN:
			*IXP4XX_GPIO_GPOUTR |= RS_GRN_ON;	//2
			return;
		case LED_DISK1:
			*IXP4XX_GPIO_GPOUTR &= DISK1_ON;	//0xfffffffb
			return;
		case LED_DISK2:	
			*IXP4XX_GPIO_GPOUTR &= DISK2_ON;	//0xfffffff7
			return;
		case LED_ALL:					//all green
			*IXP4XX_GPIO_GPOUTR |= RS_GRN_ON;
			*IXP4XX_GPIO_GPOUTR &= (DISK1_ON & DISK2_ON);
			return;	
	}
}

//--------------------------------------------------------------------------------------------------

static void n2lm_ledoff(unsigned long led)
{

	switch (led) {
		case LED_RS_RED:	
			*IXP4XX_GPIO_GPOUTR &= RS_RED_OFF;	//0xffffffffe
			return;
		case LED_RS_GRN:
			*IXP4XX_GPIO_GPOUTR &= RS_GRN_OFF;	//0xfffffffd
			return;
		case LED_DISK1:
			*IXP4XX_GPIO_GPOUTR |= DISK1_OFF;	//0x00000004
			return;
		case LED_DISK2:	
			*IXP4XX_GPIO_GPOUTR |= DISK2_OFF;	//0x00000008
			return;
		case LED_ALL:
			*IXP4XX_GPIO_GPOUTR &= (RS_GRN_OFF & RS_RED_OFF);
			*IXP4XX_GPIO_GPOUTR |= (DISK1_OFF | DISK2_OFF);
	}
}

//==================================================================================================

static int n2lm_ioctl(struct inode *inode, struct file *file, unsigned int cmd, unsigned long led)
{

	printk(KERN_DEBUG "cmd=%d, led=%ld\n", cmd, led);
	
	if (led < 0 || led >= PHYS_LEDS)
		return -EINVAL;

	switch (cmd ) {
		case N2LM_ON:
			n2lm_timer_stop(led);
			n2lm_ledon(led);
			break;
			
		case N2LM_OFF:
			n2lm_timer_stop(led);
			n2lm_ledoff(led);
			break;
			
		case N2LM_BLINK:
			n2lm_ledon(led);
			if (led == LED_RS_RED)
				n2lm_rsr_timer.data = RS_RED_TGL;
			n2lm_timer_start(led);
			break;

		case N2LM_ALT:
			if (led == LED_RS_RED)
			{
				n2lm_ledon(LED_RS_GRN);
				n2lm_ledoff(LED_RS_RED);
				n2lm_rsr_timer.data = RS_RG_ALT;
				n2lm_timer_start(LED_RS_RED);
				break;
			} else
				return -EINVAL;
		
		case N2LM_ALL_ON:
			n2lm_timer_stop_all();
			n2lm_ledon(LED_ALL);
			break;
		
		case N2LM_ALL_OFF:
			n2lm_timer_stop_all();
			n2lm_ledoff(LED_ALL);
			break;
		
		default:
			return -EINVAL;
	}

	return NOERR;
}

static struct file_operations n2lm_fops = {
	.owner		= THIS_MODULE,
	.ioctl		= n2lm_ioctl,
};
//==================================================================================================
// We can't do anything fancy here since the system tick rate is far below that required to
// generate a desirable tone.  Therefore we haven't much choice but to use a busy loop until
// I get up to speed on the timers.  The saving grace is that for the normal uses, nothing 
// important should be haprepening. 
//==================================================================================================

static void n2_buzz(int tone_delay, int duration)
{
	int i;

	*IXP4XX_GPIO_GPOER &= ~GPIO_BZ_BM;
		
	for (i = 1; i < duration; i++) {
		*IXP4XX_GPIO_GPOUTR &= ~GPIO_BZ_BM;
		udelay(tone_delay);
		*IXP4XX_GPIO_GPOUTR |= GPIO_BZ_BM;
		udelay(tone_delay);
	}
	*IXP4XX_GPIO_GPOER |= GPIO_BZ_BM;

	return;
}
//=================================================================================================

// this handles the buzzer duty cycle
static void n2bz_handler(unsigned long data)
{
	if (--bz_repeatcnt > 0) {			//if just one beep left to do
		n2bz_timer.expires = jiffies + ontime + offtime;	//next timeout
		add_timer(&n2bz_timer);					//reinit timer
	}
	n2_buzz(tone/2, ontime);
	printk(KERN_DEBUG "Count = %d\tOntime = %d\n", bz_repeatcnt, ontime);
	return;
}

//==================================================================================================

static int n2bz_ioctl(struct inode *inode, struct file *file, unsigned int cmd, unsigned long param)
{
	switch (cmd) {
		case N2BZ_BEEP:
			n2_buzz(tone/2, ontime);
			break;
	
		case N2BZ_BEEP_STOP:
			del_timer(&n2bz_timer);
			break;

		case N2BZ_BEEPS:
			if (param == 0)
				bz_repeatcnt = 0xffffffff;
			else
				bz_repeatcnt = param;
			n2bz_handler(0);
			break;
	
		case N2BZ_TONESET:
			if (param >= 250 && param <= 2000)
				tone = param;
			break;

		case N2BZ_ONTIME:
			if (param > 4 && param < 201)
				ontime = param;
			break;

		case N2BZ_SILENTTIME:
			if (param > ontime)			//enforce a reasonable duty cycle
				offtime = param;
			else
				offtime = ontime;
			break;

		case N2BZ_REPEATCNT:
			if (param == 0)
				bz_repeatcnt = 0xffffffff;
			else
				bz_repeatcnt = param;
			break;

		case N2BZ_COMBINED:
			bz_repeatcnt =  (param & 0xF0000000) >> 28;	//repeat 1 - 16
			ontime =        (param & 0x0FF00000) >> 20; 	//ontime 1 - 256 jiffies
			offtime =       (param & 0x000FFF00) >> 8;	//offtime 1 - 4095 jiffies
			tone =          (param & 0x000000FF) << 4;	//tone (1 - 255) * 16
			break;

		default:
			break;
	}
	return NOERR;
}

static struct file_operations n2bz_fops = {
	.owner		= THIS_MODULE,
	.ioctl		= n2bz_ioctl,
};

//==================================================================================================
		
static irqreturn_t n2pb_handler (int irq, void *dev_id, struct pt_regs *regs)
{
	void *ret;
	
	wake_up(&n2pb_waitq);	
	remove_proc_entry(PWR_OFF_STR, NULL);		//no parent	
	n2_buzz(N2_BEEP_PITCH_MED, N2_BEEP_DUR_MED);
	ret = create_proc_entry(PWR_OFF_STR, 0, NULL);
	printk(KERN_DEBUG "cpe ret = %p\n", ret);

// WARNING: This is RUDE...it unconditionally pulls the power plug.
// Your data will be at risk...since this is just a test system
// I am leaving it enabled...eventually userland needs to get the
// message, do an orderly shutdown and use an ioctl or something in
// /proc/powerdowm to actually have us pull the plug.

	*IXP4XX_GPIO_GPOER &= ~GPIO_PO_BM;	// enable the pwr cntl gpio
	*IXP4XX_GPIO_GPOUTR |= GPIO_PO_BM;	// do the deed

	return IRQ_HANDLED;
}

//==================================================================================================
//
//static void do_rb_timeout(unsigned long data)
//{
//	int i;
//
//	for (i = 0; i < rb_presses; i++)
//		n2_buzz(N2_BEEP_PITCH_MED,N2_BEEP_DUR_SHORT);
//	return;
//}
//
//==================================================================================================
// does nothing -- waiting for userland to define
// This thing is sorta braindead...edge triggered IRQs aren't available in the drivers yet...so
// we hang in a loop until the button is no longer pressed

struct testr {
	int	ctl;
	long	param;
};

static irqreturn_t n2rb_handler (int irq, void *dev_id, struct pt_regs *regs)
{

	static struct testr test[] = {
				 N2LM_ALL_OFF,0,
				 N2LM_ON,0,
				 N2LM_OFF,0,
				 N2LM_ON,1,
				 N2LM_ALL_OFF,1, 
				 N2LM_ON,2,
				 N2LM_OFF,2,
				 N2LM_ON,3,
				 N2LM_OFF,3,
				 N2LM_BLINK,0,
				 N2LM_OFF,0,
				 N2LM_BLINK,1,
				 N2LM_OFF,1,
				 N2LM_BLINK,2,
				 N2LM_OFF,2,
				 N2LM_BLINK,3,
				 N2LM_OFF,3,
				 N2LM_ALL_OFF,0,
				 N2LM_ALT,1,
				 N2LM_OFF,1,
				 N2LM_ALL_ON,0
	};

	printk("Reset Entry IRQ =%d Presses = %d Jiffies = %08lx\tIO = %x\tIOW = %x\n", irq, rb_presses, jiffies, (int)_IO('M',rb_presses), (int)_IOW('M',rb_presses,long));

	wake_up(&n2rb_waitq);	
  	while ((*IXP4XX_GPIO_GPINR & GPIO_RB_BM) == 0)
		;					//wait for button release

	if (rb_presses > 20) 
		rb_presses = 0;
	tone = (rb_presses * 50) + 200;
	ontime = (rb_presses*10) + 100;
	offtime = 500 - (rb_presses*20);
	printk("Ontime = %d\tOfftime = %d\tTone = %d\n",ontime,offtime,tone);
 	rb_presses++;

	n2bz_ioctl(NULL,NULL, N2BZ_BEEPS, rb_presses);	
	n2lm_ioctl(NULL,NULL, test[rb_presses].ctl, test[rb_presses].param);
//	if (rb_presses == 0) {
//		init_jiffy = jiffies;
//		init_timer (&n2rb_timer);
//		n2rb_timer.function = do_rb_timeout;
//	};
//
//	if (rb_presses == 8)
//		rb_presses = 0;
//	if (rb_presses & 1)
//		n2lm_ledon(test[rb_presses]);
//	else
//		n2lm_ledoff(test[rb_presses]);
//	
//	n2rb_timer.expires = (jiffies + RB_DELAY);
//	add_timer (&n2rb_timer);
//	if (rb_presses < 5) {
//		if (rb_presses > 0)
//			n2lm_ledoff(rb_presses);
//		n2lm_ledon(++rb_presses);
//		n2lm_timer_start(rb_presses);
//	};

	printk(KERN_DEBUG "Reset Exit IRQ=%d Presses= %d Jiffies= %08lx\n", irq, rb_presses, jiffies);
	return IRQ_HANDLED;

}

//==================================================================================================
//  What to do here is majorly undetermined...

static int n2rb_read (struct file *filp, char __user *buffer, size_t count, loff_t *ppos)
{
	printk(KERN_DEBUG "Reset Button Wait\n");
	interruptible_sleep_on(&n2rb_waitq);
	return copy_to_user(buffer, "reset", 5) ? -EFAULT : 5;

}

//==================================================================================================
//  What to do here is majorly undetermined...

static int n2pb_read (struct file *filp, char __user *buffer, size_t count, loff_t *ppos)
{
	printk(KERN_DEBUG "Power Button Wait\n");
	interruptible_sleep_on(&n2pb_waitq);
	return copy_to_user(buffer, "poweroff", 8) ? -EFAULT : 8;

}

//--------------------------------------------------------------------------------------------------

static struct file_operations n2rb_fops = {
	.owner		= THIS_MODULE,
	.read		= n2rb_read,
};

//--------------------------------------------------------------------------------------------------

static struct file_operations n2pb_fops = {
	.owner		= THIS_MODULE,
	.read		= n2pb_read,
};

//==================================================================================================

static void n2iom_initarch(void)
{
	printk(KERN_DEBUG "setup_interrupts - jiffies=%ld init_jiffy=%ld\n", jiffies, init_jiffy);

	*IXP4XX_GPIO_GPISR = 0x20400000;	// read the 2 irqs to clr
	gpio_line_config(N2_RB_GPIO, IXP4XX_GPIO_IN | IXP4XX_GPIO_ACTIVE_LOW);
	gpio_line_isr_clear(N2_RB_GPIO);
	gpio_line_config(N2_PB_GPIO, IXP4XX_GPIO_IN | IXP4XX_GPIO_ACTIVE_HIGH);
	gpio_line_isr_clear(N2_PB_GPIO);

	init_timer(&n2lm_rsg_timer);
	init_timer(&n2lm_rsr_timer);
	init_timer(&n2lm_d1_timer);
	init_timer(&n2lm_d2_timer);
//	init_timer(&n2rb_timer);
//	init_timer(&n2pb_timer);
	init_timer(&n2bz_timer);
	n2lm_rsr_timer.function = n2lm_rsr_handler;
	n2lm_rsg_timer.function = n2lm_rsg_handler;
	n2lm_d2_timer.function = n2lm_d2_handler;
	n2lm_d1_timer.function = n2lm_d1_handler;
	n2bz_timer.function = n2bz_handler;
	n2lm_rsr_timer.data = n2lm_rsg_timer.data = n2lm_d1_timer.data = n2lm_d2_timer.data = n2bz_timer.data = 0;

	*IXP4XX_GPIO_GPOER &= 0xfffffff0;	//enable gpio 0-3
	*IXP4XX_GPIO_GPOUTR |= 0x00000003;	//turn off the leds
	*IXP4XX_GPIO_GPOUTR &= 0xfffffffc;
	n2lm_ledon(LED_ALL);
	n2_buzz(N2_BEEP_PITCH_MED, N2_BEEP_DUR_SHORT);
	n2lm_ledoff(LED_ALL);
// Default the Ready/Status to Red during kernel boot, Turn Green at the end of sysvinit
	n2lm_ledon(LED_RS_RED);

	return;
}

//==================================================================================================

static int __init n2iom_init(void)
{
	printk(KERN_INFO "OpenN2 Misc I/O Driver Version %s\n", VERSION);
  	
	init_jiffy = jiffies;
	printk(KERN_DEBUG "init_jiffy=%ld\n",init_jiffy);
	n2iom_initarch();

	if (register_chrdev(N2RB_MAJOR, "n2_rbm", &n2pb_fops) < NOERR) {
		printk(KERN_DEBUG "Reset Button Major %d not available\n", N2RB_MAJOR);
		return -EBUSY;
	}
	if (register_chrdev(N2PB_MAJOR, "n2_pbm", &n2rb_fops) < NOERR) {
		printk(KERN_DEBUG "Power Button Major %d not available\n", N2PB_MAJOR);
		return -EBUSY;
	}
	if (register_chrdev(N2LM_MAJOR, "n2_ledm", &n2lm_fops) < NOERR) {
		printk(KERN_DEBUG "Led Manager Major %d not available\n", N2LM_MAJOR);
		return -EBUSY;
	}
	if (register_chrdev(N2BZ_MAJOR, "n2_bzm", &n2bz_fops) < NOERR) {
		printk(KERN_DEBUG "Buzzer Major %d not available\n", N2BZ_MAJOR);
		return -EBUSY;
	}

	if (request_irq(N2RB_IRQ, &n2rb_handler, SA_INTERRUPT, "n2_rb", NULL) < NOERR) {
		printk(KERN_DEBUG "Reset Button IRQ %d not available\n", N2RB_IRQ);
		return -EIO;
	}
	if (request_irq(N2PB_IRQ, &n2pb_handler, SA_INTERRUPT, "n2_pb", NULL) < NOERR) {
		printk(KERN_DEBUG "Power Button IRQ %d not available\n", N2PB_IRQ);
		return -EIO;	
	}
	
	enable_irq(N2PB_IRQ);
	enable_irq(N2RB_IRQ);
	return (NOERR);
}

//==================================================================================================

static void __exit n2iom_exit(void)
{
	remove_proc_entry(PWR_OFF_STR, NULL);
	del_timer(&n2rb_timer);
	free_irq(N2RB_IRQ,NULL);
	unregister_chrdev(N2PB_MAJOR, "n2pb");
	del_timer(&n2pb_timer);	
	free_irq(N2PB_IRQ, NULL);
	unregister_chrdev(N2RB_MAJOR, "n2rb" );
	del_timer(&n2lm_rsg_timer);
	del_timer(&n2lm_rsr_timer);
	del_timer(&n2lm_d1_timer);
	del_timer(&n2lm_d2_timer);	
	unregister_chrdev(N2LM_MAJOR, "n2lm" );
}

module_init (n2iom_init);
module_exit (n2iom_exit);

MODULE_AUTHOR("Karen Spearel <kas11@tampabay.rr.com>");
MODULE_DESCRIPTION("OpenN2 Buttons/LEDs IO Driver");
MODULE_LICENSE("GPL");
static int debug = 7;
module_param(debug, int, 0644);
MODULE_PARM_DESC(debug, "Debugging enabled = 8");

