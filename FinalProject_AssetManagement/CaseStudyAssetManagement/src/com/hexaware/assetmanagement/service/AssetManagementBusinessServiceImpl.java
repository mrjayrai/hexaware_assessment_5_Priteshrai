package com.hexaware.assetmanagement.service;
/*@ Author : Rajeshwari

 * Description : Implemeted Asset Management Service Interface
 * Date: 18-10-2024
 */
import java.time.LocalDate;

/*
 * @Author : Rajeshwari
 * */
import com.hexaware.assetmanagement.dao.AssetManagementServiceImpl;
import com.hexaware.assetmanagement.dao.IAssetManagementService;
import com.hexaware.assetmanagement.entity.Asset;
import com.hexaware.assetmanagement.entity.Employee;
import com.hexaware.assetmanagement.myexceptions.AssetNotFoundException;
import com.hexaware.assetmanagement.myexceptions.AssetNotMaintainException;

public class AssetManagementBusinessServiceImpl implements IAssetManagementBusinessService {

	private IAssetManagementService assetManagementService;
	
	public AssetManagementBusinessServiceImpl() {
		super();
		assetManagementService = new AssetManagementServiceImpl();
	}
	

	@Override
	public boolean maintenanceDate(int assetId) throws AssetNotMaintainException {
		// TODO Auto-generated method stub
		return assetManagementService.maintenanceDate(assetId);
	}


	@Override
	public boolean checkExistAssetId(int assetId) throws AssetNotFoundException{
		// TODO Auto-generated method stub
		boolean flag=assetManagementService.checkExistAssetId(assetId);
		return flag;
	}


	@Override
	public boolean addAsset(Asset asset) {
		// TODO Auto-generated method stub
		return assetManagementService.addAsset(asset);
	}

	@Override
	public boolean updateAsset(Asset asset) {
		// TODO Auto-generated method stub
		return assetManagementService.updateAsset(asset);
	}

	@Override
	public boolean deleteAsset(int assetId) {
		// TODO Auto-generated method stub
		return assetManagementService.deleteAsset(assetId);
	}

	

	@Override
	public boolean allocateAsset(int allocationId, int assetId, int employeeId, String allocationDate) {
		// TODO Auto-generated method stub
		return assetManagementService.allocateAsset(allocationId, assetId, employeeId, allocationDate);
	}

	@Override
	public boolean deallocateAsset(int allocationId, int employeeId, String returnDate) {
		// TODO Auto-generated method stub
		return assetManagementService.deallocateAsset(allocationId, employeeId, returnDate);
	}

	@Override
	public boolean performMaintenance(int maintenanceId,int assetId, String maintenanceDate, String description, double cost) {
		// TODO Auto-generated method stub
		return assetManagementService.performMaintenance(maintenanceId,assetId, maintenanceDate, description, cost);
	}

	@Override
	public boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) throws AssetNotFoundException {
		// TODO Auto-generated method stub
		try {
			
		
		return assetManagementService.reserveAsset(assetId, employeeId, reservationDate, startDate, endDate);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Asset Not Found");
		}
		return false;
	}

	@Override
	public boolean withdrawReservation(int reservationId) {
		// TODO Auto-generated method stub
		return assetManagementService.withdrawReservation(reservationId);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return assetManagementService.addEmployee(employee);
	}

	
}
