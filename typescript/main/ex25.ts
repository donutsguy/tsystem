interface UserInfo {
    id: number;
    name: string;
    email: string;
}

interface UserPermissions {
    canEdit: boolean;
    canDelete: boolean;
    canView: boolean;
}

interface UserDetails {
    role: string;
    department: string;
}

type AdvancedUser = UserInfo & UserPermissions & UserDetails;

const user1: AdvancedUser = {
    id: 1,
    name: 'Alice Smith',
    email: 'alice.smith@example.com',
    canEdit: true,
    canDelete: false,
    canView: true,
    role: 'Admin',
    department: 'IT'
};

const user2: AdvancedUser = {
    id: 2,
    name: 'Bob Jones',
    email: 'bob.jones@example.com',
    canEdit: false,
    canDelete: false,
    canView: true,
    role: 'User',
    department: 'Sales'
};