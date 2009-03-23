/*
 *  linux/drivers/i2c/chips/tsc2003.c
 *
 *  Copyright (C) 2005 Bill Gatliff <bgat at billgatliff.com>
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
 *  published by the Free Software Foundation.
 *
 *  Driver for TI's TSC2003 I2C Touch Screen Controller
 */

#include <linux/module.h>
#include <linux/init.h>
#include <linux/slab.h>
#include <linux/i2c.h>
#include <linux/string.h>
#include <linux/bcd.h>
#include <linux/list.h>
#include <linux/device.h>
#include <linux/interrupt.h>
#include <linux/irq.h>
#include <linux/input.h>
#include <linux/platform_device.h>
#include <asm/delay.h>
#include <linux/delay.h>

#include <asm/arch/gpio.h>

#define DRIVER_NAME "tsc2003"

enum tsc2003_pd {
	PD_POWERDOWN = 0, /* penirq */
	PD_IREFOFF_ADCON = 1, /* no penirq */
	PD_IREFON_ADCOFF = 2, /* penirq */
	PD_IREFON_ADCON = 3, /* no penirq */
	PD_PENIRQ_ARM = PD_IREFON_ADCOFF,
	PD_PENIRQ_DISARM = PD_IREFON_ADCON,
};

enum tsc2003_m {
	M_12BIT = 0,
	M_8BIT = 1
};

enum tsc2003_cmd {
	MEAS_TEMP0 = 0,
	MEAS_VBAT1 = 1,
	MEAS_IN1 = 2,
	MEAS_TEMP1 = 4,
	MEAS_VBAT2 = 5,
	MEAS_IN2 = 6,
	ACTIVATE_NX_DRIVERS = 8,
	ACTIVATE_NY_DRIVERS = 9,
	ACTIVATE_YNX_DRIVERS = 10,
	MEAS_XPOS = 12,
	MEAS_YPOS = 13,
	MEAS_Z1POS = 14,
	MEAS_Z2POS = 15
};

#define TSC2003_CMD(cn,pdn,m) (((cn) << 4) | ((pdn) << 2) | ((m) << 1))

#define ADC_MAX ((1 << 12) - 1)

struct tsc2003_data {
	struct i2c_client *client;
	struct input_dev *idev;
	struct timer_list penirq_timer;
	struct semaphore sem;
	struct task_struct *tstask;
	struct completion tstask_completion;
	enum tsc2003_pd pd;
	enum tsc2003_m m;
	int vbat1;
	int vbat2;
	int temp0;
	int temp1;
	int in1;
	int in2;
};

static int tsc2003_i2c_detect (struct i2c_adapter *adapter, int address,
			       int kind);

static inline int tsc2003_command (struct tsc2003_data *data,
	enum tsc2003_cmd cmd,
	enum tsc2003_pd pd)
{
	char c;
	int ret;
	down(&data->sem);
	c = TSC2003_CMD(cmd, pd, data->m);
	ret = i2c_master_send(data->client, &c, 1);
	up(&data->sem);
	return ret;
}

static int tsc2003_read (struct tsc2003_data *data,
	enum tsc2003_cmd cmd,
	enum tsc2003_pd pd,
	int *val)
{
	char c;
	char d[2];
	int ret;

	c = TSC2003_CMD(cmd, pd, data->m);
	ret = i2c_master_send(data->client, &c, 1);

	udelay(20);
	ret = i2c_master_recv(data->client, d, data->m == M_12BIT ? 2 : 1);

	if (val)
	{
		*val = d[0];
		*val <<= 4;
		if (data->m == M_12BIT)
			*val += (d[1] >> 4);
	}

#if defined(CONFIG_I2C_DEBUG_CHIP)
	printk(KERN_ERR "%s: val[%x] = %d\n",
	       __FUNCTION__, cmd, (((int)d[0]) << 8) + d[1]);
#endif

	return 0;
	if (!ret) ret = -ENODEV;
	return ret;
}

static inline int tsc2003_read_temp0 (struct tsc2003_data *d, enum
				      tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_TEMP0, pd, t);
}

static inline int tsc2003_read_temp1 (struct tsc2003_data *d, enum
				      tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_TEMP1, pd, t);
}

static inline int tsc2003_read_xpos (struct tsc2003_data *d, enum
				     tsc2003_pd pd, int *x)
{
	return tsc2003_read(d, MEAS_XPOS, pd, x);
}

static inline int tsc2003_read_ypos (struct tsc2003_data *d, enum
				     tsc2003_pd pd, int *y)
{
	return tsc2003_read(d, MEAS_YPOS, pd, y);
}

static inline int tsc2003_read_pressure (struct tsc2003_data *d, enum
					 tsc2003_pd pd, int *p)
{
	return tsc2003_read(d, MEAS_Z1POS, pd, p);
}

static inline int tsc2003_read_in1 (struct tsc2003_data *d, enum
				    tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_IN1, pd, t);
}

static inline int tsc2003_read_in2 (struct tsc2003_data *d, enum
				    tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_IN2, pd, t);
}

static inline int tsc2003_read_vbat1 (struct tsc2003_data *d, enum
				      tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_VBAT1, pd, t);
}

static inline int tsc2003_read_vbat2 (struct tsc2003_data *d, enum
				      tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_VBAT2, pd, t);
}

static inline int tsc2003_powerdown (struct tsc2003_data *d)
{
	/* we don't have a distinct powerdown command,
	   so do a benign read with the PD bits cleared */
	return tsc2003_read(d, MEAS_IN1, PD_POWERDOWN, 0);
}

void tsc2003_init_client (struct i2c_client *client)
{
	struct tsc2003_data *data = i2c_get_clientdata(client);

	data->pd = PD_PENIRQ_DISARM;
	data->m = M_8BIT;
	return;
}

static int tsc2003ts_thread (void *v)
{
	struct tsc2003_data *d = v;
	struct task_struct *tsk = current;
	int pendown=0;

	d->tstask = tsk;

	daemonize(DRIVER_NAME "tsd");
	allow_signal(SIGKILL);

	complete(&d->tstask_completion);

	printk(KERN_INFO "%s: address 0x%x\n",
	       __FUNCTION__, d->client->addr);

	while (!signal_pending(tsk))
	{
		unsigned int x, y, p;

		tsc2003_read_xpos(d, PD_PENIRQ_DISARM, &x);
		tsc2003_read_ypos(d, PD_PENIRQ_DISARM, &y);
		tsc2003_read_pressure(d, PD_PENIRQ_DISARM, &p);

		/* non-X-Y driver read to avoid glitch in penirq (errata?) */
		if (p > 100) {
			pendown = 1;
			input_report_abs(d->idev, ABS_X, x);
			input_report_abs(d->idev, ABS_Y, y);
			input_report_abs(d->idev, ABS_PRESSURE, p);
			input_report_key(d->idev, BTN_TOUCH, 1);
			input_sync(d->idev);
		} else if (pendown == 1) {
			pendown = 0;
			input_report_key(d->idev, BTN_TOUCH, 0);
			input_report_abs(d->idev, ABS_PRESSURE, 0);
			input_sync(d->idev);
		}
		schedule_timeout_interruptible(msecs_to_jiffies(10));
	}

	d->tstask = NULL;
	complete_and_exit(&d->tstask_completion, 0);
}

static int tsc2003_idev_open (struct input_dev *idev)
{
	struct tsc2003_data *d = idev->private;
	int ret = 0;

	if (down_interruptible(&d->sem))
		return -EINTR;

	if (d->tstask)
		panic(DRIVER_NAME "tsd already running (!). abort.");

	init_completion(&d->tstask_completion);

	ret = kernel_thread(tsc2003ts_thread, d, CLONE_KERNEL);
	if (ret >= 0) {
		wait_for_completion(&d->tstask_completion);
		ret = 0;
	}

	up(&d->sem);

	return ret;
}

static void tsc2003_idev_close (struct input_dev *idev)
{
	struct tsc2003_data *d = idev->private;
	down_interruptible(&d->sem);
	if (d->tstask)
	{
		send_sig(SIGKILL, d->tstask, 1);
		wait_for_completion(&d->tstask_completion);
	}
	up(&d->sem);
	return;
}

#if defined(CONFIG_SYSFS) && defined(CONFIG_SENSORS_TSC2003_SYSFS)
static ssize_t show_addr (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->client.addr);
}
static DEVICE_ATTR(addr, S_IRUGO, show_addr, NULL);

static ssize_t show_vbat1 (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->vbat1);
}
static DEVICE_ATTR(vbat1, S_IRUGO, show_vbat1, NULL);

static ssize_t show_vbat2 (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->vbat2);
}
static DEVICE_ATTR(vbat2, S_IRUGO, show_vbat2, NULL);

static ssize_t show_in1 (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->in1);
}
static DEVICE_ATTR(in1, S_IRUGO, show_in1, NULL);

static ssize_t show_in2 (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->in2);
}
static DEVICE_ATTR(in2, S_IRUGO, show_in2, NULL);

static ssize_t show_temp0 (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->temp0);
}
static DEVICE_ATTR(temp0, S_IRUGO, show_temp0, NULL);

static ssize_t show_temp1 (struct device *dev, char *buf)
{
	struct tsc2003_data *d = container_of(dev->driver, struct
					      tsc2003_data, driver);
	return sprintf(buf, "%d\n", d->temp1);
}
static DEVICE_ATTR(temp1, S_IRUGO, show_temp1, NULL);

#warning "TODO: this daemon sometimes hangs the touchscreen daemon"
#warning "TODO: under periods of heavy touch screen activity."
#warning "TODO: Use with caution until the bug is squashed."
static int tsc2003s_thread (void *v)
{
	struct tsc2003_data *d = v;

	daemonize(DRIVER_NAME "sd");
	allow_signal(SIGKILL);

	printk(KERN_INFO "%s: address 0x%x\n",
	       __FUNCTION__, d->client.addr);

	while (!signal_pending(current))
	{
		if (!down_interruptible(&d->sem))
		{
			if (!timer_pending(&d->penirq_timer))
			{
				tsc2003_read_vbat1(d, d->pd, &d->vbat1);
				tsc2003_read_vbat2(d, d->pd, &d->vbat2);
				tsc2003_read_in1(d, d->pd, &d->in1);
				tsc2003_read_in2(d, d->pd, &d->in2);
				tsc2003_read_temp0(d, d->pd, &d->temp0);
				tsc2003_read_temp1(d, d->pd, &d->temp1);
			}
			up(&d->sem);
		}
		set_task_state(current, TASK_INTERRUPTIBLE);
		schedule_timeout(5 * HZ);
	}
	do_exit(0);
}
#endif

static int tsc2003_driver_register (struct tsc2003_data *data)
{
	int ret = 0;

	init_MUTEX(&data->sem);

	data->idev = input_allocate_device();
	if(!data->idev)
	{
		return -ENOMEM;
	}
	data->idev->private = data;
	data->idev->name = DRIVER_NAME;
	data->idev->evbit[0] = BIT(EV_ABS);
	data->idev->open = tsc2003_idev_open;
	data->idev->close = tsc2003_idev_close;
	data->idev->absbit[LONG(ABS_X)] = BIT(ABS_X);
	data->idev->absbit[LONG(ABS_Y)] = BIT(ABS_Y);
	data->idev->absbit[LONG(ABS_PRESSURE)] = BIT(ABS_PRESSURE);
	input_set_abs_params(data->idev, ABS_X, 0, ADC_MAX, 0, 0);
	input_set_abs_params(data->idev, ABS_Y, 0, ADC_MAX, 0, 0);

	ret = input_register_device(data->idev);
	if(ret)
	{
		input_free_device(data->idev);
		return ret;
	}
	return ret;
}

/* Magic definition of all other variables and things */
static unsigned short normal_i2c[] = {0x48, 0x49, 0x4a, 0x48b, I2C_CLIENT_END };

I2C_CLIENT_INSMOD;

static int tsc2003_i2c_attach_adapter(struct i2c_adapter *adapter)
{
	return i2c_probe(adapter, &addr_data, tsc2003_i2c_detect);
}

static int tsc2003_i2c_detach_client(struct i2c_client *client)
{
	struct tsc2003_data *data=i2c_get_clientdata(client);
	int err;

	input_unregister_device(data->idev);

	err = i2c_detach_client(client);
	if (err) {
		dev_err(&client->dev, "Client deregistration failed, "
			"client not detached.\n");
		return err;
	}

	return 0;
}

static struct i2c_driver tsc2003_i2c_driver = {
	.driver = {
		.owner	= THIS_MODULE,
		.name	= DRIVER_NAME,
	},
	.attach_adapter    = tsc2003_i2c_attach_adapter,
	.detach_client    = tsc2003_i2c_detach_client,
	.command              = NULL
};

static struct i2c_client client_template = {
	.name =   "TSC2003",
	.driver = &tsc2003_i2c_driver,
};

static int tsc2003_i2c_detect (struct i2c_adapter *adap, int addr,
			       int kind)
{
	struct i2c_client *i2c;
	int ret;
	struct tsc2003_data *data;

	client_template.adapter = adap;
	client_template.addr = addr;

	printk(KERN_INFO "tsc2003 i2c touch screen controller\n");
	printk(KERN_INFO "Bill Gatliff <bgat at billgatliff.com>\n");

	i2c =  kmemdup(&client_template, sizeof(client_template), GFP_KERNEL);
	if (i2c == NULL){
		return -ENOMEM;
	}

	data = kcalloc(1, sizeof(*data), GFP_KERNEL);
	if (!data) {
		ret = -ENOMEM;
		goto err;
	}
	data->client = i2c;
	i2c_set_clientdata(i2c, data);

	ret = i2c_attach_client(i2c);

	if (ret < 0) {
		printk("failed to attach codec at addr %x\n", addr);
		goto err;
	}

	tsc2003_init_client(i2c);

	tsc2003_powerdown(data);

	ret = tsc2003_driver_register(data);
	if(ret < 0) {
		printk("driver_register failed\n");
		goto err;
	}

	return ret;

err:
	kfree(i2c);
	return ret;
}

#define tsc2003_suspend NULL
#define tsc2003_resume NULL

static int __devinit tsc2003_probe(struct platform_device *dev)
{
	int ret;

	ret=i2c_add_driver(&tsc2003_i2c_driver);
	if(ret)
		return ret;

#if defined(CONFIG_SYSFS) && defined(CONFIG_SENSORS_TSC2003_SYSFS)
	ret = kernel_thread(tsc2003s_thread, d, CLONE_KERNEL);
	if (ret >= 0)
		ret = 0;

	device_create_file(dev, &dev_attr_addr);
	device_create_file(dev, &dev_attr_vbat1);
	device_create_file(dev, &dev_attr_vbat2);
	device_create_file(dev, &dev_attr_in1);
	device_create_file(dev, &dev_attr_in2);
	device_create_file(dev, &dev_attr_temp0);
	device_create_file(dev, &dev_attr_temp1);
#endif
	return 0;
}

static int __devexit tsc2003_remove(struct platform_device *dev)
{
	i2c_del_driver(&tsc2003_i2c_driver);
	return 0;
}

static struct platform_driver tsc2003_driver = {
	.probe		= tsc2003_probe,
	.remove		= __devexit_p(tsc2003_remove),
	.suspend	= tsc2003_suspend,
	.resume		= tsc2003_resume,
	.driver		= {
		.name	= "tsc2003",
	},
};

static int __init tsc2003_init(void)
{
	return platform_driver_register(&tsc2003_driver);
}

static void __exit tsc2003_exit(void)
{
	platform_driver_unregister(&tsc2003_driver);
}

MODULE_AUTHOR("Bill Gatliff <bgat at billgatliff.com>");
MODULE_DESCRIPTION("TSC2003 Touch Screen Controller driver");
MODULE_LICENSE("GPL");

module_init(tsc2003_init);
module_exit(tsc2003_exit);
