import {BasicColumn} from '@/components/Table';
import {FormSchema} from '@/components/Table';
import { rules} from '@/utils/helper/validator';
import { render } from '@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '登录账号',
    align:"center",
    dataIndex: 'username'
   },
   {
    title: '真实姓名',
    align:"center",
    dataIndex: 'realname'
   },
   {
    title: '用户地址，唯一键',
    align:"center",
    dataIndex: 'userAddress'
   },
   {
    title: '密码',
    align:"center",
    dataIndex: 'password'
   },
   {
    title: '电子邮件',
    align:"center",
    dataIndex: 'email'
   },
   {
    title: '电话',
    align:"center",
    dataIndex: 'phone'
   },
   {
    title: '用户公钥',
    align:"center",
    dataIndex: 'userPublickey'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '登录账号',
    field: 'username',
    component: 'Input',
  },
  {
    label: '真实姓名',
    field: 'realname',
    component: 'Input',
  },
  {
    label: '用户地址，唯一键',
    field: 'userAddress',
    component: 'Input',
  },
  {
    label: '密码',
    field: 'password',
    component: 'Input',
  },
  {
    label: '电子邮件',
    field: 'email',
    component: 'Input',
  },
  {
    label: '电话',
    field: 'phone',
    component: 'Input',
  },
  {
    label: '用户公钥',
    field: 'userPublickey',
    component: 'Input',
  },
  {
    label: 'id',
    field: 'id',
    component: 'Input',
  },
];

// 高级查询数据
export const superQuerySchema = {
  username: {title: '登录账号',order: 0,view: 'text', type: 'string',},
  realname: {title: '真实姓名',order: 1,view: 'text', type: 'string',},
  userAddress: {title: '用户地址，唯一键',order: 2,view: 'text', type: 'string',},
  password: {title: '密码',order: 3,view: 'text', type: 'string',},
  email: {title: '电子邮件',order: 4,view: 'text', type: 'string',},
  phone: {title: '电话',order: 5,view: 'text', type: 'string',},
  userPublickey: {title: '用户公钥',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
