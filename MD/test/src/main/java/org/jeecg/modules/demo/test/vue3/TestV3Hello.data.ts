import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '名字',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '年龄',
    align:"center",
    dataIndex: 'age'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'sex_dictText'
   },
   {
    title: '生日',
    align:"center",
    dataIndex: 'birthday',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'cc'
   },
   {
    title: 'as',
    align:"center",
    dataIndex: 'asdd'
   },
   {
    title: 'aa',
    align:"center",
    dataIndex: 'aaa'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '名字',
    field: 'name',
    component: 'Input',
  },
  {
    label: '年龄',
    field: 'age',
    component: 'InputNumber',
  },
  {
    label: '性别',
    field: 'sex',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sex"
     },
  },
  {
    label: '生日',
    field: 'birthday',
    component: 'DatePicker',
  },
  {
    label: '备注',
    field: 'cc',
    component: 'InputTextArea',
  },
  {
    label: 'as',
    field: 'asdd',
    component: 'Input',
  },
  {
    label: 'aa',
    field: 'aaa',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '名字',order: 0,view: 'text', type: 'string',},
  age: {title: '年龄',order: 1,view: 'number', type: 'number',},
  sex: {title: '性别',order: 2,view: 'list', type: 'string',dictCode: 'sex',},
  birthday: {title: '生日',order: 3,view: 'date', type: 'string',},
  cc: {title: '备注',order: 4,view: 'textarea', type: 'string',},
  asdd: {title: 'as',order: 5,view: 'text', type: 'string',},
  aaa: {title: 'aa',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}